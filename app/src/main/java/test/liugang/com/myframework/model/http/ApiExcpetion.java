package test.liugang.com.myframework.model.http;

/**
 * @类的用途：
 * @author: 刘刚
 * @date: 2017/7/14
 */

public class ApiExcpetion extends RuntimeException{
    public ApiExcpetion(String msg){
        super(msg);
    }
}
