package test.liugang.com.myframework.presenter;

import java.util.Map;

import test.liugang.com.myframework.base.BasePresenter;
import test.liugang.com.myframework.model.bean.RegistBean;
import test.liugang.com.myframework.model.http.GetRetrofit;
import test.liugang.com.myframework.model.http.HttpClient;
import test.liugang.com.myframework.model.http.MySubscribe;
import test.liugang.com.myframework.view.IView.RegistView;

/**
 * @ Description:
 * @ Date:2017/7/24
 * @ Author:刘刚
 */

public class RegistPresenter extends BasePresenter<RegistView> {
    public void getRegistData( Map<String,String> map){
        HttpClient.subcribe(GetRetrofit.getApi().getRegistData(map), new MySubscribe<RegistBean>() {
            @Override
            public void onSuccess(RegistBean myBean) {
                mView.onSuccess(myBean);
            }

        });

    }
}
