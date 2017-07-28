package test.liugang.com.myframework.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.utils.EventBusUtil;

/**
 * @ Description:
 * @ Date:2017/7/13
 * @ Author:刘刚
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{

    protected Activity mContext;
    protected  T mPresenter;
    private ProgressDialog dialog;
    private Unbinder unbinder;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //acticity跳转动画——右进左出
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        createPresenter();
        init();
        initView();
        initData();
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
    }

    private void init(){
        mContext = this;
        mFragmentManager = getSupportFragmentManager();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }

    }
    public void showLoading() {
        if (dialog != null && dialog.isShowing()) return;
        dialog = new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求网络中...");
        dialog.show();
    }

    public void dismissLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }





    @Override
    protected void onDestroy() {
        if (mPresenter!=null){
            mPresenter.detachView();
        }
        if (isRegisterEventBus()){
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
        unbinder.unbind();
    }

    /** 初始化 Toolbar */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, int resTitle) {
        initToolBar(toolbar, homeAsUpEnabled, getString(resTitle));
    }
    public void fragmentReplace(int layoutID, Fragment fragment){
         mFragmentManager.beginTransaction()
                 .replace(layoutID,fragment)
                 .commit();
    }

    public void fragmentAdd(int layoutID,Fragment fragment){
        fragmentAdd(layoutID,fragment,null);
    }

    public void fragmentAdd(int layoutID, Fragment fragment,String tag){
        FragmentTransaction add = mFragmentManager.beginTransaction()
                .add(layoutID, fragment);
        if (null!=tag){
            add.addToBackStack(tag);
        }
        add.commit();
    }


    public void fragmentHide(Fragment fragment){
         mFragmentManager.beginTransaction().hide(fragment).commit();
    }

    public void fragmentShow(Fragment fragment){
        mFragmentManager
                .beginTransaction()
                .show(fragment)
                .commit();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // TODO Auto-generated method stub
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 注册EventBus
     * false：默认值 非注册状态
     * true ：进行EventBus注解，以及解绑工作
     */
    protected abstract boolean isRegisterEventBus();


    protected abstract int getLayout();
    protected abstract void  initView();
    protected abstract void initData();
    protected abstract void createPresenter();
}
