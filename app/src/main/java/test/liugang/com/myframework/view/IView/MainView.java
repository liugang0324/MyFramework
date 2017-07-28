package test.liugang.com.myframework.view.IView;

import test.liugang.com.myframework.base.BaseView;
import test.liugang.com.myframework.model.bean.MyBean;

/**
 * @ Description:
 * @ Date:2017/7/17
 * @ Author:刘刚
 */

public interface MainView extends BaseView {
 void onSuccess(MyBean myBean);
}
