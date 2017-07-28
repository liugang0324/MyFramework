package test.liugang.com.myframework.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import test.liugang.com.myframework.R;
import test.liugang.com.myframework.app.Event;
import test.liugang.com.myframework.app.EventCode;
import test.liugang.com.myframework.base.BaseActivity;
import test.liugang.com.myframework.presenter.FragCommendPresenter;
import test.liugang.com.myframework.view.IView.FragCommendView;
import test.liugang.com.myframework.view.fragment.FragMenuCollection;
import test.liugang.com.myframework.view.fragment.FragMenuFollow;
import test.liugang.com.myframework.view.fragment.FragMenuFollow_hot;
import test.liugang.com.myframework.view.fragment.FragMenuNotify;
import test.liugang.com.myframework.view.fragment.FragMenuSearch;

public class MenuActivity extends BaseActivity<FragCommendPresenter>implements FragCommendView {
    private static final String TAG = MenuActivity.class.getSimpleName();
    private Fragment isFragment=new FragMenuFollow();
    private FragMenuFollow fmf ;
    private FragMenuCollection fmc ;
    private FragMenuSearch fms ;
    private FragMenuNotify fmn ;
    private FragMenuFollow_hot fmh ;


    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_menu;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");
        if(tag.equals("follow")){
            if(fmf==null) {
                fmf = new FragMenuFollow();
            }
            switchContent(isFragment,fmf);
        }else if(tag.equals("collection")){
            if(fmc==null) {
                fmc = new FragMenuCollection();
            }
            switchContent(isFragment,fmc);
        }else if(tag.equals("notify")){
            if(fmn==null) {
                fmn = new FragMenuNotify();
            }
            switchContent(isFragment,fmn);
        }else if(tag.equals("search")){
            if(fms==null) {
                fms = new FragMenuSearch();
            }
            switchContent(isFragment,fms);
        }
    }

    @Override
    protected void createPresenter() {

    }


    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFailed() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showFragment2Follow(Event<String> event){
        Log.i(TAG, "showFragment2Follow: 接收消息");
        if(fmh==null) {
            fmh = new FragMenuFollow_hot();
        }
        if (event.getCode()== EventCode.Code.A){
            super.fragmentHide(fmf);
            if (fmh.isAdded()){
              super.fragmentShow(fmh);
            }else {
                super.fragmentAdd(R.id.menu_frame,fmh);
            }
        }else if (event.getCode()== EventCode.Code.B){
            super.fragmentHide(fmh);
            super.fragmentShow(fmf);
        }
    }

    /**
     * 当fragment进行切换时，采用隐藏与显示的方法加载fragment以防止数据的重复加载
     * @param from
     * @param to
     */
    public void switchContent(Fragment from, Fragment to) {
        if (isFragment != to) {
            isFragment = to;

            if (!to.isAdded()) {
                // 先判断是否被add过
                fragmentHide(from);
                fragmentAdd(R.id.menu_frame, to);
                // 隐藏当前的fragment，add下一个到Activity中
            } else {
                fragmentHide(from);
                fragmentShow(to);
                // 隐藏当前的fragment，显示下一个
            }
        }
    }
}
