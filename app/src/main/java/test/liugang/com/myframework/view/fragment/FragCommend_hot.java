package test.liugang.com.myframework.view.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.base.BaseFragment;
import test.liugang.com.myframework.model.bean.JokeBean;
import test.liugang.com.myframework.view.adapter.FragCommend_recyclerAdapter;
import test.liugang.com.myframework.view.autoview.GlideImageLoader;

/**
 * @ Description:
 * @ Date:2017/7/22
 * @ Author:刘刚
 */

public class FragCommend_hot extends BaseFragment {
    @BindView(R.id.banner)
    Banner banner;
    List<String> image = new ArrayList<>();
    @BindView(R.id.hot_recycler)
    RecyclerView mHotRecycler;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_commend_hot;
    }

    @Override
    protected void initView() {

        image.add("https://a-ssl.duitang.com/uploads/item/201603/05/20160305105135_t3kfS.thumb.700_0.jpeg");
        image.add("https://b-ssl.duitang.com/uploads/item/201603/02/20160302152113_KQt4C.thumb.700_0.jpeg");

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(image);

        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Accordion);
        //设置标题集合（当banner样式有显示title时）
        // banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    protected void initData() {
        List<JokeBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            JokeBean jokeBean = new JokeBean();
            jokeBean.setTitle("天气美美的，适合郊游");
            jokeBean.setTime("2017-07-28 20:13");
            jokeBean.setUser("天蝎喝牛奶");
            list.add(jokeBean);
        }

        FragCommend_recyclerAdapter adapter = new FragCommend_recyclerAdapter(mContext);
        mHotRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        mHotRecycler.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        mHotRecycler.setAdapter(adapter);
        adapter.setData(list);
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected void initEvent() {

    }


}
