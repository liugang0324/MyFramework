package test.liugang.com.myframework.view.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.base.BaseFragment;
import test.liugang.com.myframework.model.bean.FollowBean;
import test.liugang.com.myframework.presenter.FragFollow_allPresenter;
import test.liugang.com.myframework.view.IView.FragFollow_allView;
import test.liugang.com.myframework.view.adapter.FragFollow_recyclerAdapter;

/**
 * @ Description:
 * @ Date:2017/7/27
 * @ Author:刘刚
 */

public class FragFollow_all extends BaseFragment<FragFollow_allPresenter> implements FragFollow_allView {
    @BindView(R.id.follow_recycler)
    RecyclerView mFollowRecycler;

    @Override
    protected int getLayoutId() {
        return R.layout.fragfollow_all;
    }

    @Override
    protected void initView() {
        mFollowRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        mFollowRecycler.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));

    }

    @Override
    protected void initData() {
        FragFollow_recyclerAdapter adapter = new FragFollow_recyclerAdapter(mContext);
        List<FollowBean>list=new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            FollowBean bean = new FollowBean();
            bean.setTitle("阿斯顿马丁");
            bean.setContent("吃货们快戳我");
            bean.setTime("2017-07-27 11:24");

            list.add(bean);
        }
        adapter.setData(list);
        mFollowRecycler.setAdapter(adapter);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new FragFollow_allPresenter();
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFailed() {

    }

}
