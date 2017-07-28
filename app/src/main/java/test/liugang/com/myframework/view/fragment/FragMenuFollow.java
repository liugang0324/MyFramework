package test.liugang.com.myframework.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.app.Event;
import test.liugang.com.myframework.app.EventCode;
import test.liugang.com.myframework.base.BaseFragment;
import test.liugang.com.myframework.presenter.FragCommendPresenter;
import test.liugang.com.myframework.view.IView.FragCommendView;
import test.liugang.com.myframework.view.adapter.FragCommendViewPagerAdapter;

import static com.shuyu.gsyvideoplayer.GSYVideoPlayer.TAG;

/**
 * @类的用途：
 * @author: 刘刚
 * @date: 2017/7/19
 */

public class FragMenuFollow extends BaseFragment<FragCommendPresenter> implements FragCommendView, View
        .OnClickListener {

    Unbinder unbinder;
    @BindView(R.id.menuone_img_return)
    ImageView mMenuoneImgReturn;
    @BindView(R.id.menuone_text_return)
    TextView mMenuoneTextReturn;
    @BindView(R.id.menuone_title_center)
    TextView mMenuoneTitleCenter;
    @BindView(R.id.menuone_title_right)
    TextView mMenuoneTitleRight;
    @BindView(R.id.head_title)
    Toolbar mHeadTitle;
    @BindView(R.id.follow_tabLayout)
    TabLayout mFollowTabLayout;
    @BindView(R.id.follow_vp)
    ViewPager mFollowVp;


    @Override
    protected int getLayoutId() {
        return R.layout.frag_my_follow;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mMenuoneImgReturn.setOnClickListener(this);
        mMenuoneTextReturn.setOnClickListener(this);
        mMenuoneTitleCenter.setText("我的关注");
        mMenuoneTitleRight.setText("热门关注");

        List<String> slist=new ArrayList<>();
        List<Fragment> flist=new ArrayList<>();
        slist.add("全部");
        slist.add("爆笑");
        slist.add("励志");
        slist.add("美食");
        slist.add("网红");
        slist.add("颜值");

        for (int i = 0; i < slist.size(); i++) {
            flist.add(new FragFollow_all());
        }
        FragCommendViewPagerAdapter fragCommendViewPagerAdapter = new FragCommendViewPagerAdapter(getFragmentManager(), flist, slist);
        mFollowVp.setAdapter(fragCommendViewPagerAdapter);

        // 关联TabLayout与ViewPager，且适配器必须重写getPageTitle()方法
        mFollowTabLayout.setupWithViewPager(mFollowVp);

        mMenuoneTitleRight.setOnClickListener(this);
    }


    @Override
    protected void createPresenter() {
        mPresenter=new FragCommendPresenter();
    }

    @Override
    protected void initEvent() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menuone_img_return:
                mActivity.finish();
                break;
            case R.id.menuone_text_return:
                mActivity.finish();
                break;
            case R.id.menuone_title_right:
                Log.i(TAG, "onClick: 发送消息");
                EventBus.getDefault().post(new Event<String>(EventCode.Code.A,"follows"));
                break;
        }
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFailed() {

    }
}
