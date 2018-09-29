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
import java.util.List;

/**
 * Created by zhucheng on 2017/11/4.
 */

class ChannelAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ResultBeanData.ChannelBean> mData;

    public ChannelAdapter(Context context, ArrayList<ResultBeanData.ChannelBean> mData) {
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
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.gv_item_channel,null);
            holder = new ViewHolder();
            holder.iv_channel = view.findViewById(R.id.iv_channel);
            holder.tv_channel = view.findViewById(R.id.tv_channel);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_channel.setText(mData.get(i).getChannel());
        holder.iv_channel.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(context).load(mData.get(i).getIcon_channel()).into(holder.iv_channel);

        return view;
    }

    class ViewHolder{
        TextView tv_channel;
        ImageView iv_channel;
    }
}
