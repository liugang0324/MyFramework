package test.liugang.com.myframework.view.IView;

import test.liugang.com.myframework.base.BaseView;

/**
 * @ Description:
 * @ Date:2017/7/26
 * @ Author:刘刚
 */

public interface FragJokeView extends BaseView {
    void onSuccess(Object o);
    void onFailed();
}
