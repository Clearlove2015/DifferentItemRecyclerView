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

class HotAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ResultBeanData.HotBean> mData;

    public HotAdapter(Context context, ArrayList<ResultBeanData.HotBean> mData) {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_hot,null);
            holder = new ViewHolder();
            holder.iv_hot = view.findViewById(R.id.iv_hot);
            holder.tv_hot = view.findViewById(R.id.tv_hot);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_hot.setText(mData.get(i).getHot_name());
        Glide.with(context).load(mData.get(i).getIcon_hot()).into(holder.iv_hot);
        return view;
    }

    class ViewHolder{
        ImageView iv_hot;
        TextView tv_hot;
    }
}
