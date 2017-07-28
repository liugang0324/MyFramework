package test.liugang.com.myframework.model.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.liugang.com.myframework.BuildConfig;
import test.liugang.com.myframework.app.App;
import test.liugang.com.myframework.model.Contents;
import test.liugang.com.myframework.model.cache.CacheInterceptor;

/**
 * @ Description:
 * @ Date:2017/7/17
 * @ Author:刘刚
 */

public class GetRetrofit {


    public static Retrofit getRetrofit(){

        //设置缓存路径
        File cacheDir = new File(App.mContext.getExternalFilesDir("response").getPath());
        //设置缓存大小
        int cacheSize=10*1024*1024;
        Cache cache = new Cache(cacheDir, cacheSize);
        OkHttpClient.Builder okclient = new OkHttpClient.Builder();
         okclient.retryOnConnectionFailure(true)//连接失败后是否重新连接
                .connectTimeout(15, TimeUnit.SECONDS)//超时时间15S
                .addInterceptor(new CacheInterceptor())//也就这里不同
                .addNetworkInterceptor(new CacheInterceptor())//也就这里不同
                .cache(cache)
                .build();

        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okclient.addInterceptor(httpLoggingInterceptor);
        }

        return  new Retrofit.Builder()
                .baseUrl(Contents.BASE_URL)
                .client(okclient.build())
                .addConverterFactory(GsonConverterFactory .create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public static ApiServices getApi(){
        return getRetrofit().create(ApiServices.class);
    }
}
