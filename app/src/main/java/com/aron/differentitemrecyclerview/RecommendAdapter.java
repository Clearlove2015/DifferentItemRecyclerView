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

class RecommendAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ResultBeanData.RecommendBean> mData;

    public RecommendAdapter(Context context, ArrayList<ResultBeanData.RecommendBean> mData) {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_recommend,null);
            holder = new ViewHolder();
            holder.iv_recommend = view.findViewById(R.id.iv_recommend);
            holder.tv_recommend = view.findViewById(R.id.tv_recommend);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_recommend.setText(mData.get(i).getRecommend_name());
        Glide.with(context).load(mData.get(i).getIcon_recommend()).into(holder.iv_recommend);
        return view;
    }

    class ViewHolder{
        ImageView iv_recommend;
        TextView tv_recommend;
    }
}
