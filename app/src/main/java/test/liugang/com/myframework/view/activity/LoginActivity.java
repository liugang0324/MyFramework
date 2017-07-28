package test.liugang.com.myframework.view.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.base.BaseActivity;
import test.liugang.com.myframework.model.bean.LoginBean;
import test.liugang.com.myframework.presenter.LoginPresenter;
import test.liugang.com.myframework.utils.ToastUtils;
import test.liugang.com.myframework.view.IView.LoginView;

public class LoginActivity extends BaseActivity<LoginPresenter>implements LoginView, View.OnClickListener {


    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.login_progress)
    ProgressBar mLoginProgress;
    @BindView(R.id.login_phone)
    EditText mPhone;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.account_sign_in_button)
    Button mAccountSignInButton;
    @BindView(R.id.regist)
    TextView mRegist;
    @BindView(R.id.find_pwd)
    TextView mFindPwd;
    @BindView(R.id.account_login_form)
    LinearLayout mAccountLoginForm;
    @BindView(R.id.login_form)
    ScrollView mLoginForm;
    @BindView(R.id.head_title)
    Toolbar mHeadTitle;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mAccountSignInButton.setOnClickListener(this);
        mRegist.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        initToolBar(mHeadTitle, true, "登陆");
    }

    @Override
    protected void createPresenter() {
        mPresenter=new LoginPresenter();
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.regist:
                Intent intent = new Intent(this,RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.account_sign_in_button:
                Map<String,String> map=new HashMap<>();
                map.put("userPhone",mPhone.getText().toString().trim());
                map.put("userPassword",mPassword.getText().toString().trim());
                mPresenter.getLoginData(map);
                break;
        }
    }

    @Override
    public void onSuccess(LoginBean myBean) {
        ToastUtils.showShort(LoginActivity.this,"登陆成功"+myBean.toString());
    }
}
