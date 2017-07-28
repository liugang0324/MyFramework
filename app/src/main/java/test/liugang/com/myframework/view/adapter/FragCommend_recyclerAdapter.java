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
import test.liugang.com.myframework.model.bean.JokeBean;
/*
*
 * @ Description:
 * @ Date:2017/7/25
 * @ Author:刘刚
 */


public class FragCommend_recyclerAdapter extends RecyclerView.Adapter<FragCommend_recyclerAdapter.MyHolder> {

    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private List<JokeBean>list=new ArrayList<>();
    //private FragCommend_hotPresenter mPresenter;
    public FragCommend_recyclerAdapter(Context context) {
        mContext = context;
    }
    public void setData(List<JokeBean> mlist){
        if (mlist!=null){
            this.list.addAll(mlist);
        }
    }
  /*  public void setPresenter(FragCommend_hotPresenter presenter){
        this.mPresenter=presenter;
    }*/

    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.mOnItemClickListener=itemClickListener;

    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder holder = new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.item_commend_hot,null,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tv_hot_user.setText(list.get(position).getUser());
        holder.tv_hot_time.setText(list.get(position).getTime());
        holder.tv_hot_title.setText(list.get(position).getTitle());
    }


    public  interface OnItemClickListener{
        void onClick(int position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private final ImageView img_hot_head,img_hot_selcet;
        private final TextView tv_hot_user,tv_hot_time,tv_hot_title,tv_hot_copyLink,tv_hot_jubao,tv_hot_pingbi;

        public MyHolder(View itemView) {
            super(itemView);
            img_hot_head = (ImageView) itemView.findViewById(R.id.img_hot_head);
            img_hot_selcet= (ImageView) itemView.findViewById(R.id.img_hot_selcet);
            tv_hot_user = (TextView) itemView.findViewById(R.id.tv_hot_user);
            tv_hot_time= (TextView) itemView.findViewById(R.id.tv_hot_time);
            tv_hot_title= (TextView) itemView.findViewById(R.id.tv_hot_title);
            tv_hot_copyLink= (TextView) itemView.findViewById(R.id.tv_hot_copyLink);
            tv_hot_jubao= (TextView) itemView.findViewById(R.id.tv_hot_jubao);
            tv_hot_pingbi= (TextView) itemView.findViewById(R.id.tv_hot_pingbi);
        }
    }
}
