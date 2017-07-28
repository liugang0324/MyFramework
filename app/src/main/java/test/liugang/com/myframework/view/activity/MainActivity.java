package test.liugang.com.myframework.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import butterknife.BindView;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.app.App;
import test.liugang.com.myframework.base.BaseActivity;
import test.liugang.com.myframework.model.bean.MyBean;
import test.liugang.com.myframework.presenter.MainPresenter;
import test.liugang.com.myframework.utils.ScreenUtils;
import test.liugang.com.myframework.view.IView.MainView;
import test.liugang.com.myframework.view.autoview.CircleImageView;
import test.liugang.com.myframework.view.editPic.PublishedActivity;
import test.liugang.com.myframework.view.fragment.FragCommend;
import test.liugang.com.myframework.view.fragment.FragJoke;
import test.liugang.com.myframework.view.fragment.FragVideo;


public class MainActivity extends BaseActivity<MainPresenter> implements MainView, BottomNavigationBar.OnTabSelectedListener, View.OnClickListener {
    @BindView(R.id.leftimage)
    CircleImageView mLeftimage;
    @BindView(R.id.tv_custom)
    TextView mTvCustom;
    @BindView(R.id.img_right)
    ImageView mImgRight;
    private FragCommend fc = new FragCommend();
    private FragJoke fj = new FragJoke();
    private FragVideo fv = new FragVideo();

    @BindView(R.id.home_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.home_bottombar)
    BottomNavigationBar mNavBottom;
    private SlidingMenu mMenu;
    private ImageView mUser_img;
    private Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mLeftimage.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        // showLoading();
        initToolBar(mToolbar, false, "主界面");
        initNavBar();
        initSlidingmenu();
    }

    private void initSlidingmenu() {
        mMenu = new SlidingMenu(App.mContext);
        mMenu.setMode(SlidingMenu.LEFT);
        mMenu.setOffsetFadeDegree(0.4f);
        // 设置触摸屏幕的模式
        mMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

        // menu.setShadowWidthRes(R.dimen.shadow_width);
        //menu.setShadowDrawable(R.mipmap.ic_launcher);
        View left_view = View.inflate(MainActivity.this, R.layout.left_menu, null);
        mUser_img = (ImageView) left_view.findViewById(R.id.user_img);
        TextView tv_my_follow= (TextView) left_view.findViewById(R.id.tv_my_follow);
        TextView tv_my_collection= (TextView) left_view.findViewById(R.id.tv_my_collection);
        TextView tv_search_friend= (TextView) left_view.findViewById(R.id.tv_search_friend);
        TextView tv_msg_notify= (TextView) left_view.findViewById(R.id.tv_msg_notify);

        tv_my_follow.setOnClickListener(this);
        tv_my_collection.setOnClickListener(this);
        tv_search_friend.setOnClickListener(this);
        tv_msg_notify.setOnClickListener(this);
        mUser_img.setOnClickListener(this);

        /* NavigationView navigationView = (NavigationView) left_view.findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        //获取头布局文件
        View headerView = navigationView.getHeaderView(0);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //在这里处理item的点击事件
                return true;
            }
        });
*/
        mMenu.setMenu(left_view);
        // 设置滑动菜单视图的宽度
        int slidingmenu_offset = ScreenUtils.getScreenWidth(App.mContext) * 1 / 4;
        mMenu.setBehindOffset(slidingmenu_offset);
        // 设置渐入渐出效果的值
        mMenu.setFadeDegree(0.35f);
        mMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        mLeftimage.setOnClickListener(this);
        mImgRight.setOnClickListener(this);

    }


    private void initNavBar() {

        BottomNavigationItem item1 = new BottomNavigationItem(R.mipmap.raw_1500085367, "推荐");
        item1.setInactiveIconResource(R.mipmap.raw_1500083878).setActiveColor(R.color.skyblue).setInActiveColor(R.color.gainsboro);
        BottomNavigationItem item2 = new BottomNavigationItem(R.mipmap.raw_1500085899, "段子");
        item2.setInactiveIconResource(R.mipmap.raw_1500085327).setActiveColor(R.color.skyblue).setInActiveColor(R.color.gainsboro);
        BottomNavigationItem item3 = new BottomNavigationItem(R.mipmap.raw_1500086067, "视频");
        item3.setInactiveIconResource(R.mipmap.raw_1500083686).setActiveColor(R.color.skyblue).setInActiveColor(R.color.gainsboro);
        mNavBottom.addItem(item1).addItem(item2).addItem(item3).setFirstSelectedPosition(0).initialise();


        //MODE_SHIFTING
        mNavBottom.setMode(BottomNavigationBar.MODE_FIXED);//点击模式
        //BACKGROUND_STYLE_STATIC
        //BACKGROUND_STYLE_DEFAULT
        mNavBottom.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mNavBottom.setTabSelectedListener(this);
        fragmentAdd(R.id.relative, fc);
        fragmentAdd(R.id.relative, fj);
        fragmentAdd(R.id.relative, fv);
        setDefaultFragment();
        mIntent = new Intent(mContext, MenuActivity.class);
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        mTvCustom.setText("推荐");
        fragmentShow(fc);
        fragmentHide(fj);
        fragmentHide(fv);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new MainPresenter();
    }


    @Override
    public void onSuccess(MyBean myBean) {
        dismissLoading();
    }


    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                fragmentShow(fc);
                fragmentHide(fj);
                fragmentHide(fv);
                mTvCustom.setText("推荐");
                break;
            case 1:
                fragmentShow(fj);
                fragmentHide(fc);
                fragmentHide(fv);
                mTvCustom.setText("段子");
                break;
            case 2:
                fragmentShow(fv);
                fragmentHide(fj);
                fragmentHide(fc);
                mTvCustom.setText("视频");
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.leftimage:
                if (!mMenu.isMenuShowing()) {
                    mMenu.toggle();
                }
                break;
            case R.id.img_right:
                Intent intent=new Intent(MainActivity.this, PublishedActivity.class);
                startActivity(intent);
                break;
            case R.id.user_img:
                Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_my_follow:
                if (mIntent == null) {
                    mIntent = new Intent();
                }
                mIntent.putExtra("tag", "follow");
                startActivity(mIntent);
                break;
            case R.id.tv_my_collection:
                if (mIntent == null) {
                    mIntent = new Intent();
                }
                mIntent.putExtra("tag", "collection");
                startActivity(mIntent);
                break;
            case R.id.tv_search_friend:
                if (mIntent == null) {
                    mIntent = new Intent();
                }
                mIntent.putExtra("tag", "search");
                startActivity(mIntent);
                break;
            case R.id.tv_msg_notify:
                if (mIntent == null) {
                    mIntent = new Intent();
                }
                mIntent.putExtra("tag", "notify");
                startActivity(mIntent);
                break;
        }
    }

}
