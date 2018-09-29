package com.aron.differentitemrecyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * Created by zhucheng on 2017/11/3.
 */

class MyRecyclerViewAdapter extends RecyclerView.Adapter {

    private final static int BANNER = 0;//轮播
    private final static int CHANNEL = 1;//频道
    private final static int ACTIVITY = 2;//活动
    private final static int SECONDKILL = 3;//秒杀
    private final static int RECOMMEND = 4;//推荐
    private final static int HOT = 5;//热卖

    private Context context;
    private ResultBeanData resultBeanData;
    private final LayoutInflater inflater;

    public MyRecyclerViewAdapter(Context context, ResultBeanData resultBeanData) {
        this.context = context;
        this.resultBeanData = resultBeanData;
        inflater = LayoutInflater.from(context);
    }

    private int type;

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                type =  BANNER;
                break;
            case 1:
                type = CHANNEL;
                break;
            case 2:
                type = ACTIVITY;
                break;
            case 3:
                type = SECONDKILL;
                break;
            case 4:
                type = RECOMMEND;
                break;
            case 5:
                type = HOT;
                break;
        }
        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case BANNER:
                return new BannerViewHolder(inflater.inflate(R.layout.rv_item_banner,null));
            case CHANNEL:
                return new ChannelViewHolder(inflater.inflate(R.layout.rv_item_channel,null));
            case ACTIVITY:
                return new ActViewHolder(inflater.inflate(R.layout.rv_item_activity,null));
            case SECONDKILL:
                return new SecKillViewHolder(inflater.inflate(R.layout.rv_item_secondkill,null));
            case RECOMMEND:
                return new RecommendViewHolder(inflater.inflate(R.layout.rv_item_recommend,null));
            case HOT:
                return new HotViewHolder(inflater.inflate(R.layout.rv_item_hot,null));
        }
        return null;
    }

    /**
     * 根据不同类型item绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (position){
            case 0:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                bannerViewHolder.setData(resultBeanData.imagesUrl);
                break;
            case 1:
                ChannelViewHolder channelViewHolder = (ChannelViewHolder) holder;
                channelViewHolder.setData(resultBeanData.channels);
                break;
            case 2:
                ActViewHolder actViewHolder = (ActViewHolder) holder;
                actViewHolder.setData(resultBeanData.acts);
                break;
            case 3:
                SecKillViewHolder secKillViewHolder = (SecKillViewHolder) holder;
                secKillViewHolder.setData(resultBeanData.secKills);
                break;
            case 4:
                RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
                recommendViewHolder.setData(resultBeanData.recommends);
                break;
            case 5:
                HotViewHolder hotViewHolder = (HotViewHolder) holder;
                hotViewHolder.setData(resultBeanData.hots);
                break;
        }
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder{
        Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }

        public void setData(ArrayList<String> mData){
            Log.e("TAG","BannerSize = " + mData.size());
            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            //设置图片集合
            banner.setImages(mData);
            //banner设置方法全部调用完毕时最后调用
            banner.start();
        }
    }

    private class ChannelViewHolder extends RecyclerView.ViewHolder {
        GridView gridView;

        public ChannelViewHolder(View itemView) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gv_channel);

        }

        public void setData(ArrayList<ResultBeanData.ChannelBean> mData){
            gridView.setAdapter(new ChannelAdapter(context,mData));
        }
    }

    private class ActViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        RecyclerView recyclerView;
        public ActViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rv_activity);
            tv_title = itemView.findViewById(R.id.tv_title);
        }

        public void setData(ArrayList<ResultBeanData.ActBean> mData){
            tv_title.setText("活动");
            recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            recyclerView.setAdapter(new ActAdapter(context,mData));
        }
    }

    private class SecKillViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        GridView gridView;

        public SecKillViewHolder(View itemView) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gv_secondkill);
            tv_title = itemView.findViewById(R.id.tv_title);
        }

        public void setData(ArrayList<ResultBeanData.SecKillBean> mData){
            tv_title.setText("秒杀");
            gridView.setAdapter(new SecKillAdapter(context,mData));
        }
    }

    private class RecommendViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        GridView gridView;

        public RecommendViewHolder(View itemView) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gv_recommend);
            tv_title = itemView.findViewById(R.id.tv_title);
        }

        public void setData(ArrayList<ResultBeanData.RecommendBean> mData){
            gridView.setAdapter(new RecommendAdapter(context,mData));
            tv_title.setText("推荐");
        }
    }

    private class HotViewHolder extends RecyclerView.ViewHolder {
        GridView gridView;
        TextView tv_title;

        public HotViewHolder(View itemView) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gv_hot);
            tv_title = itemView.findViewById(R.id.tv_title);
        }

        public void setData(ArrayList<ResultBeanData.HotBean> mData){
            gridView.setAdapter(new HotAdapter(context,mData));
            tv_title.setText("热卖");
        }
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //Picasso 加载图片简单用法
            Glide.with(context).load((String) path).into(imageView);

        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }

}
