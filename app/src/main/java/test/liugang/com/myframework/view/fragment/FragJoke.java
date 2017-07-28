package test.liugang.com.myframework.view.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.base.BaseFragment;
import test.liugang.com.myframework.model.bean.JokeBean;
import test.liugang.com.myframework.presenter.FragJoke_Presenter;
import test.liugang.com.myframework.view.IView.FragJokeView;
import test.liugang.com.myframework.view.adapter.FragJoke_recyclerAdapter;

/**
 * @ Description:
 * @ Date:2017/7/19
 * @ Author:刘刚
 */

public class FragJoke extends BaseFragment<FragJoke_Presenter> implements FragJokeView {
    @BindView(R.id.joke_recycler)
    RecyclerView mJokeRecycler;
    List<JokeBean>list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.frag_joke;
    }

    @Override
    protected void initView() {
        mJokeRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mJokeRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void initData() {
        for (int i = 0; i <10 ; i++) {
            JokeBean jokeBean = new JokeBean();
            jokeBean.setUser("天蝎喝牛奶");
            jokeBean.setCheck(false);
            jokeBean.setTime("2017-05-23  14:25");
            jokeBean.setTitle("印度情报部门称:中国战争愿望空前高涨，" +
                    "每一个城市几乎每一条街道都明目张胆的张贴着标语定位带我到山顶撒发生" +
                    "发顺丰发啥啊嘎嘎,打发发所付付付付付付付付付付付付付付付发发发发发" +
                    "付付付付付付付付付付付付付付付付付付付印度情报部门称:中国战争愿望空前高涨印度情报部门称:中国战争愿望空前高涨");
            list.add(jokeBean);
        }
        FragJoke_recyclerAdapter adapter = new FragJoke_recyclerAdapter(getActivity());
        adapter.setData(list);
        mJokeRecycler.setAdapter(adapter);
    }

    @Override
    protected void createPresenter() {
        mPresenter=new FragJoke_Presenter();
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
