package test.liugang.com.myframework.view.fragment;


import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.base.BaseFragment;
import test.liugang.com.myframework.presenter.FragCommendPresenter;
import test.liugang.com.myframework.view.IView.FragCommendView;
import test.liugang.com.myframework.view.adapter.FragCommendViewPagerAdapter;

/**
 * @ Description:
 * @ Date:2017/7/19
 * @ Author:刘刚
 */

public class FragCommend extends BaseFragment<FragCommendPresenter> implements FragCommendView {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private Unbinder mUnbinder;
    private ViewPager mVp;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_commend;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        List<Fragment>flist=new ArrayList<>();
        FragCommend_hot fragCommend_hot = new FragCommend_hot();
        FragCommend_focus fragCommend_focus = new FragCommend_focus();
        flist.add(fragCommend_hot);
        flist.add(fragCommend_focus);
        List<String>slist=new ArrayList<>();
        slist.add("热门");
        slist.add("关注");
       FragCommendViewPagerAdapter fragCommendViewPagerAdapter = new FragCommendViewPagerAdapter(getFragmentManager(), flist, slist);

//        FragCommendViewPagerAdapter fragCommendViewPagerAdapter = new FragCommendViewPagerAdapter(getFragmentManager(),  slist);
        mViewPager.setAdapter(fragCommendViewPagerAdapter);
        // 关联TabLayout与ViewPager，且适配器必须重写getPageTitle()方法
        mTabLayout.setupWithViewPager(mViewPager);

    }

    public static void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());
        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabLayout, 60, 60);
            }
        });
    }


    @Override
    protected void createPresenter() {
        mPresenter=new FragCommendPresenter();
    }

    @Override
    protected void initEvent() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFailed() {

    }
}
