package test.liugang.com.myframework.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.liugang.com.myframework.R;
import test.liugang.com.myframework.model.bean.FollowBean;
import test.liugang.com.myframework.presenter.FragFollow_allPresenter;
/*
*
 * @ Description:
 * @ Date:2017/7/25
 * @ Author:刘刚
 */


public class FragFollow_recyclerAdapter extends RecyclerView.Adapter<FragFollow_recyclerAdapter.MyHolder> {

    private List<FollowBean>list=new ArrayList<>();
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private FragFollow_allPresenter  mPresenter;
    public FragFollow_recyclerAdapter(Context context) {
        mContext = context;
    }
    public void setData(List<FollowBean> mlist){
        if (mlist!=null){
            this.list.addAll(mlist);
        }
    }
    public void setPresenter(FragFollow_allPresenter presenter){
        this.mPresenter=presenter;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.mOnItemClickListener=itemClickListener;

    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder holder = new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.item_follow_all,null,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tv_follow_time.setText(list.get(position).getTime());
        holder.tv_follow_content.setText(list.get(position).getContent());
        holder.tv_follow_title.setText(list.get(position).getTitle());
    }


    public  interface OnItemClickListener{
        void onClick(int position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private final ImageView img_follow_all,img_arrow_rigth;
        private final TextView tv_follow_time,tv_follow_content,tv_follow_title;

        public MyHolder(View itemView) {
            super(itemView);
            img_follow_all = (ImageView) itemView.findViewById(R.id.img_follow_all);
            img_arrow_rigth= (ImageView) itemView.findViewById(R.id.img_arrow_rigth);
            tv_follow_time = (TextView) itemView.findViewById(R.id.tv_follow_time);
            tv_follow_content= (TextView) itemView.findViewById(R.id.tv_follow_content);
            tv_follow_title= (TextView) itemView.findViewById(R.id.tv_follow_title);
        }
    }
}
