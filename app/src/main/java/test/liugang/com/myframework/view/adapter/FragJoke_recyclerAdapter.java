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
import test.liugang.com.myframework.presenter.FragJoke_Presenter;
import test.liugang.com.myframework.utils.AnimUtils;

/**
 * @ Description:
 * @ Date:2017/7/26
 * @ Author:刘刚
 */

public class FragJoke_recyclerAdapter extends RecyclerView.Adapter<FragJoke_recyclerAdapter.MyHolder> {

    private Context mContext;
    private List<JokeBean>list=new ArrayList<>();
    private FragJoke_recyclerAdapter.OnItemClickListener mOnItemClickListener;
    private FragJoke_Presenter mPresenter;

    public FragJoke_recyclerAdapter(Context context) {
        mContext = context;
    }
    public void setData(List<JokeBean> mlist){
        if (mlist!=null){
            this.list.addAll(mlist);
        }
    }
    public void setPresenter(FragJoke_Presenter presenter){
        this.mPresenter=presenter;
    }

    public void setOnItemClickListener(FragJoke_recyclerAdapter.OnItemClickListener itemClickListener){
        this.mOnItemClickListener=itemClickListener;

    }
    @Override
    public FragJoke_recyclerAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragJoke_recyclerAdapter.MyHolder holder = new FragJoke_recyclerAdapter.MyHolder(LayoutInflater.from(mContext).inflate(R.layout.item_joke,null,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final FragJoke_recyclerAdapter.MyHolder holder, final int position) {
        holder.tv_joke_user.setText(list.get(position).getUser());
        holder.tv_joke_time.setText(list.get(position).getTime());
        holder.tv_joke_title.setText(list.get(position).getTitle());
        holder.img_joke_selcet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (list.get(position).getCheck() == false) {
                        list.get(position).setCheck(true);
                        holder.img_joke_selcet.setImageResource(R.mipmap.b6);
                        holder.tv_joke_msg.setVisibility(View.VISIBLE);
                        holder.tv_joke_collect.setVisibility(View.VISIBLE);
                        holder.tv_joke_share.setVisibility(View.VISIBLE);
                        AnimUtils.setJokeAnimShow(holder.tv_joke_collect, 0, -(holder.tv_joke_collect.getWidth() * 3 / 2), 0f, 1f).start();
                        AnimUtils.setJokeAnimShow(holder.tv_joke_share, 0, -(holder.tv_joke_share.getWidth() * 3), 0f, 1f).start();
                        AnimUtils.setJokeAnimShow(holder.tv_joke_msg, 0, -(holder.tv_joke_msg.getWidth() * 9 / 2), 0f, 1f).start();


                    } else {
                        list.get(position).setCheck(false);
                        holder.img_joke_selcet.setImageResource(R.mipmap.b9);
                        holder.tv_joke_msg.setVisibility(View.VISIBLE);
                        holder.tv_joke_collect.setVisibility(View.VISIBLE);
                        holder.tv_joke_share.setVisibility(View.VISIBLE);

                        AnimUtils.setJokeAnimShow(holder.tv_joke_collect, -(holder.tv_joke_collect.getWidth() * 3 / 2), 0, 1f, 0f).start();
                        AnimUtils.setJokeAnimShow(holder.tv_joke_share, -(holder.tv_joke_share.getWidth() * 3), 0, 1f, 0f).start();
                        AnimUtils.setJokeAnimShow(holder.tv_joke_msg, -(holder.tv_joke_msg.getWidth() * 9 / 2), 0, 1f, 0f).start();
                    }
                }
        });

    }


    public  interface OnItemClickListener{
        void onClick(int position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private final ImageView img_joke_head,img_joke_selcet;
        private final TextView tv_joke_user,tv_joke_time,tv_joke_title,tv_joke_share,tv_joke_msg,tv_joke_collect;

        public MyHolder(View itemView) {
            super(itemView);
            img_joke_head = (ImageView) itemView.findViewById(R.id.img_joke_head);
            img_joke_selcet= (ImageView) itemView.findViewById(R.id.img_joke_selcet);
            tv_joke_share= (TextView) itemView.findViewById(R.id.tv_joke_share);
            tv_joke_msg= (TextView) itemView.findViewById(R.id.tv_joke_msg);
            tv_joke_collect= (TextView) itemView.findViewById(R.id.tv_joke_collect);
            tv_joke_user = (TextView) itemView.findViewById(R.id.tv_joke_user);
            tv_joke_time= (TextView) itemView.findViewById(R.id.tv_joke_time);
            tv_joke_title= (TextView) itemView.findViewById(R.id.tv_joke_title);
        }
    }
}
