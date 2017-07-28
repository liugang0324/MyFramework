package test.liugang.com.myframework.base;

/**
 * @ Description:
 * @ Date:2017/7/17
 * @ Author:刘刚
 */

public class BaseBean<T>  {
 private int code;
    private T datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }
}
