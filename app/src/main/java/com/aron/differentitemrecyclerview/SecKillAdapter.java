package com.aron.differentitemrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by zhucheng on 2017/11/4.
 */

class SecKillAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ResultBeanData.SecKillBean> mData;

    public SecKillAdapter(Context context, ArrayList<ResultBeanData.SecKillBean> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view== null){
            view = LayoutInflater.from(context).inflate(R.layout.item_seckill,null);
            holder = new ViewHolder();
            holder.iv_seckill = view.findViewById(R.id.iv_seckill);
            holder.tv_seckill = view.findViewById(R.id.tv_seckill);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_seckill.setText(mData.get(i).getSeckill_name());
        Glide.with(context).load(mData.get(i).getIcon_seckill()).into(holder.iv_seckill);

        return view;
    }

    class ViewHolder {
        TextView tv_seckill;
        ImageView iv_seckill;
    }
}
