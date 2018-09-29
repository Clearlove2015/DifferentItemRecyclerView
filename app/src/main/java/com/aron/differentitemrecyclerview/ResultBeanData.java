package com.aron.differentitemrecyclerview;

import java.util.ArrayList;

/**
 * Created by zhucheng on 2017/11/4.
 */

public class ResultBeanData {

    ArrayList<String> imagesUrl = new ArrayList<>();
    ArrayList<ChannelBean> channels = new ArrayList<>();
    ArrayList<ActBean> acts = new ArrayList<>();
    ArrayList<SecKillBean> secKills = new ArrayList<>();
    ArrayList<RecommendBean> recommends = new ArrayList<>();
    ArrayList<HotBean> hots = new ArrayList<>();

    public ResultBeanData() {
        setBanner();
        setChannel();
        setAct();
        setSecKill();
        setRecommend();
        setHot();
    }

    /**
     * 初始化banner数据
     */
    public void setBanner() {
        ArrayList<String> list = new ArrayList<>();
        list.add("http://upload.youzu.com/youzu/2014/1117/164506268_1.jpg");
        list.add("http://s.yunfan.com/topv/upload/sv/201503/18/55092704da1c6.gif");
        list.add("http://img4.dwstatic.com/lol/1509/305721282251/1441766609852.jpg");
        imagesUrl = list;
    }

    /**
     * 初始化频道数据
     */
    public void setChannel() {
        ChannelBean channelBean = new ChannelBean();
        channelBean.setIcon_channel("http://www.easyicon.net/api/resizeApi.php?id=1128943&size=128");
        channelBean.setChannel("频道");
        for (int i = 0; i < 8; i++) {
            channels.add(channelBean);
        }
    }

    /**
     * 初始化活动数据
     */
    public void setAct() {
        ActBean actBean = new ActBean();
        actBean.setIcon_act("http://www.easyicon.net/api/resizeApi.php?id=1128936&size=128");
        actBean.setAct_name("活动");
        for (int i = 0; i < 8; i++) {
            acts.add(actBean);
        }
    }

    /**
     * 初始化秒杀数据
     */
    public void setSecKill() {
        SecKillBean secKillBean = new SecKillBean();
        secKillBean.setIcon_seckill("http://www.easyicon.net/api/resizeApi.php?id=1128907&size=128");
        secKillBean.setSeckill_name("秒杀");
        for (int i = 0; i < 4; i++) {
            secKills.add(secKillBean);
        }
    }

    /**
     * 初始化推荐数据
     */
    public void setRecommend(){
        RecommendBean recommendBean = new RecommendBean();
        recommendBean.setIcon_recommend("http://www.easyicon.net/api/resizeApi.php?id=1128940&size=128");
        recommendBean.setRecommend_name("推荐");
        for (int i = 0;i<4;i++){
            recommends.add(recommendBean);
        }
    }

    /**
     * 初始化热卖数据
     */
    public void setHot(){
        HotBean hotBean = new HotBean();
        hotBean.setIcon_hot("http://www.easyicon.net/api/resizeApi.php?id=1128913&size=128");
        hotBean.setHot_name("热卖");
        for (int i = 0;i<4;i++){
            hots.add(hotBean);
        }
    }

    class ChannelBean {
        String icon_channel, channel;

        public ChannelBean() {
        }

        public String getIcon_channel() {
            return icon_channel;
        }

        public void setIcon_channel(String icon_channel) {
            this.icon_channel = icon_channel;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }
    }

    class ActBean {
        String icon_act, act_name;

        public ActBean() {
        }

        public String getIcon_act() {
            return icon_act;
        }

        public void setIcon_act(String icon_act) {
            this.icon_act = icon_act;
        }

        public String getAct_name() {
            return act_name;
        }

        public void setAct_name(String act_name) {
            this.act_name = act_name;
        }
    }

    class SecKillBean {
        String icon_seckill, seckill_name;

        public SecKillBean() {
        }

        public String getIcon_seckill() {
            return icon_seckill;
        }

        public void setIcon_seckill(String icon_seckill) {
            this.icon_seckill = icon_seckill;
        }

        public String getSeckill_name() {
            return seckill_name;
        }

        public void setSeckill_name(String seckill_name) {
            this.seckill_name = seckill_name;
        }
    }

    class RecommendBean {
        String icon_recommend, recommend_name;

        public RecommendBean() {
        }

        public String getIcon_recommend() {
            return icon_recommend;
        }

        public void setIcon_recommend(String icon_recommend) {
            this.icon_recommend = icon_recommend;
        }

        public String getRecommend_name() {
            return recommend_name;
        }

        public void setRecommend_name(String recommend_name) {
            this.recommend_name = recommend_name;
        }
    }

    class HotBean {
        String icon_hot, hot_name;

        public HotBean() {
        }

        public String getIcon_hot() {
            return icon_hot;
        }

        public void setIcon_hot(String icon_hot) {
            this.icon_hot = icon_hot;
        }

        public String getHot_name() {
            return hot_name;
        }

        public void setHot_name(String hot_name) {
            this.hot_name = hot_name;
        }
    }


}
