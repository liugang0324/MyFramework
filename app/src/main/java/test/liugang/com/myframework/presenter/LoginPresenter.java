package test.liugang.com.myframework.presenter;

import java.util.Map;

import test.liugang.com.myframework.base.BasePresenter;
import test.liugang.com.myframework.model.bean.LoginBean;
import test.liugang.com.myframework.model.http.GetRetrofit;
import test.liugang.com.myframework.model.http.HttpClient;
import test.liugang.com.myframework.model.http.MySubscribe;
import test.liugang.com.myframework.view.IView.LoginView;

/**
 * @ Description:
 * @ Date:2017/7/24
 * @ Author:刘刚
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    public void getLoginData( Map<String,String> map){
        HttpClient.subcribe(GetRetrofit.getApi().getLoginData(map), new MySubscribe<LoginBean>() {
            @Override
            public void onSuccess(LoginBean myBean) {
                mView.onSuccess(myBean);
            }

        });

    }

}
