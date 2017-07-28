package test.liugang.com.myframework.view.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.base.BaseActivity;

public class LoginWayActivity extends BaseActivity {


    @BindView(R.id.loginWay)
    Button mLoginWay;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login_way;
    }

    @Override
    protected void initView() {
        mLoginWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               UMShareAPI.get(mContext).getPlatformInfo(mContext, SHARE_MEDIA.QQ, new UMAuthListener() {
                   @Override
                   public void onStart(SHARE_MEDIA share_media) {

                   }

                   @Override
                   public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                       Toast.makeText(mContext, "成功了"+map.get("name"), Toast.LENGTH_LONG).show();
                   }

                   @Override
                   public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                       Toast.makeText(mContext, "失败：" + throwable.getMessage(),                                  Toast.LENGTH_LONG).show();
                   }

                   @Override
                   public void onCancel(SHARE_MEDIA share_media, int i) {
                       Toast.makeText(mContext, "取消了", Toast.LENGTH_LONG).show();
                   }
               });
            }
        });
    }

    @Override
    protected void initData() {
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }

    }

    @Override
    protected void createPresenter() {

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
