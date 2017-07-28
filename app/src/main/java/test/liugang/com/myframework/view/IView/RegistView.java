package test.liugang.com.myframework.view.IView;

import test.liugang.com.myframework.base.BaseView;
import test.liugang.com.myframework.model.bean.RegistBean;

/**
 * @ Description:
 * @ Date:2017/7/24
 * @ Author:刘刚
 */

public interface RegistView extends BaseView {
    void onSuccess(RegistBean myBean);
}
