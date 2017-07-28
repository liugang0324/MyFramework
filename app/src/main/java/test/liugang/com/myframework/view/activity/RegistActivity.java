package test.liugang.com.myframework.view.activity;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.base.BaseActivity;
import test.liugang.com.myframework.model.bean.RegistBean;
import test.liugang.com.myframework.presenter.RegistPresenter;
import test.liugang.com.myframework.utils.ToastUtils;
import test.liugang.com.myframework.view.IView.RegistView;

public class RegistActivity extends BaseActivity<RegistPresenter> implements RegistView, View.OnClickListener {


    @BindView(R.id.head_title)
    Toolbar mHeadTitle;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.regist_account)
    EditText mRegistAccount;
    @BindView(R.id.regist_password)
    EditText mRegistPassword;
    @BindView(R.id.regist_phone)
    EditText mRegistPhone;
    @BindView(R.id.regist_sex)
    EditText mRegistSex;
    @BindView(R.id.account_sign_in_button)
    Button mAccountSignInButton;
    private Map<String, String> map;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initView() {
        mAccountSignInButton.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        initToolBar(mHeadTitle, true, "注册");

    }

    @Override
    protected void createPresenter() {
        mPresenter=new RegistPresenter();
    }


    @Override
    public void onSuccess(RegistBean myBean) {
        ToastUtils.showShort(RegistActivity.this,"注册成功");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.account_sign_in_button:
                map = new HashMap<>();
                map.put("userName",mRegistAccount.getText().toString().trim());
                map.put("userPassword",mRegistPassword.getText().toString().trim());
                map.put("userPhone",mRegistPhone.getText().toString().trim());
                map.put("userSex",mRegistSex.getText().toString().trim());
                mPresenter.getRegistData(map);
                break;
        }
    }
}
