package test.liugang.com.myframework.model.http;

import android.util.Log;

import java.net.ConnectException;
import java.net.SocketException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @ Description:
 * @ Date:2017/7/17
 * @ Author:刘刚
 */

public abstract class MySubscribe<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T value) {
        onSuccess(value);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if(e instanceof ApiExcpetion){
            Log.d("TAG"," 服务器异常 : " +e);
        }else if(e instanceof ConnectException){
            Log.d("TAG"," 连接超时 : " +e);
        }else if(e instanceof SocketException){
            Log.d("TAG"," 连接超时 : " +e);
        }else if(e instanceof HttpException){
            Log.d("TAG","请检查您的网络连接 稍后重试" + " =￣ω￣=");
        }
    }

    @Override
    public void onComplete() {

    }


    public abstract void onSuccess(T t);
}



