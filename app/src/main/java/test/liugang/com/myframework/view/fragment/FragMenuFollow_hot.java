package test.liugang.com.myframework.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.app.Event;
import test.liugang.com.myframework.app.EventCode;
import test.liugang.com.myframework.base.BaseFragment;
import test.liugang.com.myframework.presenter.FragCommendPresenter;
import test.liugang.com.myframework.view.IView.FragCommendView;
import test.liugang.com.myframework.view.adapter.FragCommendViewPagerAdapter;

/**
 * @类的用途：
 * @author: 刘刚
 * @date: 2017/7/19
 */

public class FragMenuFollow_hot extends BaseFragment<FragCommendPresenter> implements FragCommendView, View
        .OnClickListener {


    @BindView(R.id.menuone_text_return)
    TextView mMenuoneTextReturn;
    @BindView(R.id.menuone_title_center)
    TextView mMenuoneTitleCenter;
    @BindView(R.id.menuone_title_right)
    EditText mMenuoneTitleRight;
    @BindView(R.id.head_title)
    Toolbar mHeadTitle;
    @BindView(R.id.follow_hot_tabLayout)
    TabLayout mFollowHotTabLayout;
    @BindView(R.id.hot_view)
    View mHotView;
    @BindView(R.id.follow_hot_vp)
    ViewPager mFollowHotVp;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_my_follow_hot;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mMenuoneTextReturn.setOnClickListener(this);
        mMenuoneTitleCenter.setText("热门关注");

        List<String> slist = new ArrayList<>();
        List<Fragment> flist = new ArrayList<>();
        slist.add("新闻");
        slist.add("爆笑");
        slist.add("励志");
        slist.add("美食");
        slist.add("网红");
        slist.add("颜值");

        for (int i = 0; i < slist.size(); i++) {
            flist.add(new FragFollow_all());
        }
        FragCommendViewPagerAdapter fragCommendViewPagerAdapter = new FragCommendViewPagerAdapter(getFragmentManager(), flist, slist);
        mFollowHotVp.setAdapter(fragCommendViewPagerAdapter);

        // 关联TabLayout与ViewPager，且适配器必须重写getPageTitle()方法
        mFollowHotTabLayout.setupWithViewPager(mFollowHotVp);

        mMenuoneTitleRight.setOnClickListener(this);
    }


    @Override
    protected void createPresenter() {
        mPresenter = new FragCommendPresenter();
    }

    @Override
    protected void initEvent() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menuone_text_return:
                EventBus.getDefault().post(new Event<String>(EventCode.Code.B, "follows"));
                break;
            case R.id.menuone_title_right:

                break;
        }
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFailed() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
