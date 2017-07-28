package test.liugang.com.myframework.base;

import android.os.Message;

/**
 * @ Description:
 * @ Date:2017/7/13
 * @ Author:刘刚
 */

public class BasePresenter<T extends BaseView> {
  /*  //订阅
    void attachView(T view);

    //注销
    void detachView();*/
protected T mView;
    protected Message mMessage;

    public T getView() {
        return mView;
    }

    public void attachView(T t) {
        this.mView = t;
        mMessage = new Message();
    }

    public void detachView() {
        if (mView != null) {
            mView = null;
        }
        if (mMessage != null) {
            mMessage = null;
        }
    }
}
