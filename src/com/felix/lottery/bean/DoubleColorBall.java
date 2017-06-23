package com.felix.lottery.bean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: Felix
 * Date: 2017/6/22
 * Time: 20:24
 */
public class DoubleColorBall {

    private String kaijqs;
    private String red1;
    private String red2;
    private String red3;
    private String red4;
    private String red5;
    private String red6;
    private String blue;

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public String getBlue() {

        return blue;
    }

    private String kjdate;

    public String getKaijqs() {
        return kaijqs;
    }

    public String getRed1() {
        return red1;
    }

    public String getRed2() {
        return red2;
    }

    public String getRed3() {
        return red3;
    }

    public String getRed4() {
        return red4;
    }

    public String getRed5() {
        return red5;
    }

    public String getRed6() {
        return red6;
    }

    public String getKjdate() {
        return kjdate;
    }

    public void setKaijqs(String kaijqs) {
        this.kaijqs = kaijqs;
    }

    public void setRed1(String red1) {
        this.red1 = red1;
    }

    public void setRed2(String red2) {
        this.red2 = red2;
    }

    public void setRed3(String red3) {
        this.red3 = red3;
    }

    public void setRed4(String red4) {
        this.red4 = red4;
    }

    public void setRed5(String red5) {
        this.red5 = red5;
    }

    public void setRed6(String red6) {
        this.red6 = red6;
    }

    public void setKjdate(String kjdate) {
        this.kjdate = kjdate;
    }

    @Override
    public String toString() {
        return "开奖期数：" + this.getKaijqs() +
                "\r\n开奖日期：" + this.getKjdate() +
                "\r\n中奖红色球：" + this.getRed1() + "," + this.getRed2() + "," +
                this.getRed3() + "," + this.getRed4() + "," + this.getRed5() + "," +
                this.getRed6() + "\r\n中奖蓝色球：" + this.getBlue();
    }
}
