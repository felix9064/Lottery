package com.felix.lottery.bean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: Felix
 * Date: 2017/7/14
 * Time: 9:53
 */
public class Analyze {

    private String kaijqs;
    private int redsum;
    private int jishus;
    private int oushus;
    private int eqlast;
    private int lianxh;


    public Analyze() {
    }

    public void setKaijqs(String kaijqs) {
        this.kaijqs = kaijqs;
    }

    public void setRedsum(int redsum) {
        this.redsum = redsum;
    }

    public void setJishus(int jishus) {
        this.jishus = jishus;
    }

    public void setOushus(int oushus) {
        this.oushus = oushus;
    }

    public void setEqlast(int eqlast) {
        this.eqlast = eqlast;
    }

    public void setLianxh(int lianxh) {
        this.lianxh = lianxh;
    }

    public String getKaijqs() {
        return kaijqs;
    }

    public int getRedsum() {
        return redsum;
    }

    public int getJishus() {
        return jishus;
    }

    public int getOushus() {
        return oushus;
    }

    public int getEqlast() {
        return eqlast;
    }

    public int getLianxh() {
        return lianxh;
    }

    @Override
    public String toString() {
        return "[开奖期数：" + this.getKaijqs() + "\r\n" +
                "红色球和值：" + this.getRedsum() + "\r\n" +
                "红色球奇数个数：" + this.getJishus() + "\r\n" +
                "红色球偶数个数：" + this.getOushus() + "\r\n" +
                "红色球与上期重复个数：" + this.getEqlast() + "\r\n" +
                "红色球3连号个数" + this.getLianxh() + "]";
    }
}
