package com.aron.differentitemrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by zhucheng on 2017/11/4.
 */

class ActAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ResultBeanData.ActBean> mData;

    public ActAdapter(Context context, ArrayList<ResultBeanData.ActBean> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_activity,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        setData((ViewHolder)holder,position);
    }

    private void setData(ViewHolder holder,int position) {
        holder.tv_act.setText(mData.get(position).getAct_name());
        Glide.with(context).load(mData.get(position).getIcon_act()).into(holder.iv_act);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_act;
        TextView tv_act;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_act = itemView.findViewById(R.id.iv_act);
            tv_act = itemView.findViewById(R.id.tv_act);
        }
    }
}
