package com.yulu.zhaoxinpeng.myrecyclerdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {


    private List<String> mList;

    public MainAdapter(List<String> list) {
        this.mList = list;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainViewHolder holder = new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tv_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MainViewHolder holder, final int position) {
        holder.mTextView.setText(mList.get(position));

        if (onItemClickListener!=null) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //调用接口的短按方法
                    onItemClickListener.onItemClick(holder.itemView,position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    //调用接口的长按方法
                    onItemClickListener.onItemLongClick(holder.itemView,position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public MainViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    // ------------------------------------  item的点击事件（接口回调）----------------------------------------
    protected interface OnItemClickListener{

        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    private OnItemClickListener onItemClickListener;

    //对外提供一个方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
}
