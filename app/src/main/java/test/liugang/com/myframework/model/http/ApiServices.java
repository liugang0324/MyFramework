package test.liugang.com.myframework.model.http;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import test.liugang.com.myframework.model.bean.LoginBean;
import test.liugang.com.myframework.model.bean.RegistBean;

/**
 * @ Description:
 * @ Date:2017/7/17
 * @ Author:刘刚
 */

public interface ApiServices {

   @FormUrlEncoded
   @POST("user/addUser")

    Observable<RegistBean> getRegistData(@FieldMap Map<String, String> options);


    @FormUrlEncoded
    @POST("user/addLogin")
    Observable<LoginBean> getLoginData(@FieldMap Map<String, String> options);
}
