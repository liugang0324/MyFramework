package test.liugang.com.myframework.model.cache;

import android.util.Log;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import test.liugang.com.myframework.app.App;
import test.liugang.com.myframework.utils.NewWorkUtil;

/**
 * @ Description:
 * @ Date:2017/7/18
 * @ Author:刘刚
 */

public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();//获取请求
        //这里就是说判读我们的网络条件，要是有网络的话我么就直接获取网络上面的数据，要是没有网络的话我么就去缓存里面取数据
        if(!NewWorkUtil.isNetworkConnected(App.mContext)){
            request = request.newBuilder()
                    //这个的话内容有点多啊，大家记住这么写就是只从缓存取，想要了解这个东西我等下在
                    // 给大家写连接吧。大家可以去看下，获取大家去找拦截器资料的时候就可以看到这个方面的东西反正也就是缓存策略。
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Log.d("CacheInterceptor","no network");
        }
        Response originalResponse = chain.proceed(request);
        if(NewWorkUtil.isNetworkConnected(App.mContext)){
            //这里大家看点开源码看看.header .removeHeader做了什么操作很简答，就是的加字段和减字段的。
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder()
                    //这里设置的为0就是说不进行缓存，我们也可以设置缓存时间
                    .header("Cache-Control", "public, max-age=" + 60)
                    .removeHeader("Pragma")
                    .build();
        }else{
            int maxTime = 4*24*60*60;
            return originalResponse.newBuilder()
                    //这里的设置的是我们的没有网络的缓存时间，想设置多少就是多少。
                    .header("Cache-Control", "public, only-if-cached, max-stale="+maxTime)
                    .removeHeader("Pragma")
                    .build();
        }
    }
}


