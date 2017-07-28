package test.liugang.com.myframework.view.fragment;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.Unbinder;
import test.liugang.com.myframework.R;
import test.liugang.com.myframework.base.BaseFragment;
import test.liugang.com.myframework.presenter.FragCommendPresenter;
import test.liugang.com.myframework.view.IView.FragCommendView;

/**
 * @类的用途：
 * @author: 刘刚
 * @date: 2017/7/19
 */

public class FragMenuCollection extends BaseFragment<FragCommendPresenter> implements FragCommendView, View
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



    @Override
    protected int getLayoutId() {
        return R.layout.frag_my_collection;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mMenuoneImgReturn.setOnClickListener(this);
        mMenuoneTextReturn.setOnClickListener(this);
        mMenuoneTitleCenter.setText("我的收藏");
        mMenuoneTitleRight.setText("删除");
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected void initEvent() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menuone_img_return:
                mActivity.finish();
                break;
            case R.id.menuone_text_return:
                mActivity.finish();
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
