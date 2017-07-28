package test.liugang.com.myframework.model.http;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @ Description:
 * @ Date:2017/7/17
 * @ Author:刘刚
 */

public class HttpClient {
/*   public static<T> void subcribe(Observable<BaseBean<T>> observable, Observer<T> observer){
       observable.subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .map(new Function<BaseBean<T>, T>() {
                   @Override
                   public T apply(BaseBean<T> tBaseBean) throws Exception {

                       return tBaseBean.getDatas();
                   }
               })
               .subscribe(observer);
   }*/

    public static<T> void subcribe(Observable<T> observable, Observer<T> observer){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
