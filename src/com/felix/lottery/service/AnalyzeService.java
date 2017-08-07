package com.felix.lottery.service;

import com.felix.lottery.bean.Analyze;
import com.felix.lottery.bean.Kaijhm;
import com.felix.lottery.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created with IntelliJ IDEA.
 * Description: 红色球开奖结果分析
 * Author: Felix
 * Date: 2017/7/14
 * Time: 15:26
 */
public class AnalyzeService {

    public static final String NAMESPACE = "com.felix.lottery.mapping.LotteryMapper";

    /**
     * 插入analyze表
     * @param analyze
     * @return
     */
    public int insertAnalyze(Analyze analyze){
        String statement = NAMESPACE + ".insertAnalyze";
        SqlSession sqlSession = DBUtils.getSqlSession();
        int count = sqlSession.insert(statement, analyze);
        sqlSession.close();
        return count;
    }

    /**
     * 从指定期数开始循环分析红色球开奖信息，并将分析结果插入Analyze表
     * @param kaijqs 指定开奖期数
     */
    public void batchInsertAnalyze(String kaijqs) {
        String statement = NAMESPACE + ".insertAnalyze";
        SqlSession sqlSession = DBUtils.getSqlSession();

        int kjsq = Integer.parseInt(kaijqs);
        KaijhmService ks = new KaijhmService();

        while (true) {
            Kaijhm kaijhm = ks.getKaijhmByQS(kjsq + "");
            if (kaijhm == null) {
                break;
            }

            Analyze analyze = new Analyze();

            analyze.setKaijqs(kjsq + "");
            analyze.setRedsum(this.getSumRedBall(kaijhm));
            analyze.setJishus(this.getJishu(kaijhm));
            analyze.setOushus(this.getOushu(kaijhm));

            if(kjsq == 2017001) {
                analyze.setEqlast(0);
            } else {
                String lastqs = (kjsq - 1) + "";
                Kaijhm lastKaijhm = ks.getKaijhmByQS(lastqs);
                analyze.setEqlast(this.getEqLast(kaijhm, lastKaijhm));
            }
            analyze.setLianxh(this.getLianxuhm(kaijhm));

            sqlSession.insert(statement, analyze);
            kjsq++;
        }
        sqlSession.close();
    }

    /**
     * 计算指定期数的所有红色球的和值
     * @param kaijhm 开奖信息
     * @return 红色球和值
     */
    private int getSumRedBall(Kaijhm kaijhm) {
        int sum = 0;
        int[] red = kaijhm.toArray();
        for (int redball : red) {
            sum += redball;
        }
        return sum;
    }

    /**
     * 计算指定期数的红色球奇数的个数
     * @param kaijhm 开奖信息
     * @return 红色球奇数个数
     */
    private int getJishu(Kaijhm kaijhm) {

        int[] red = kaijhm.toArray();
        int number = 0;

        for (int i: red) {
            if (i % 2 != 0) {
                number++;
            }
        }

        return number;
    }

    /**
     * 计算指定期数的红色球偶数的个数
     * @param kaijhm 开奖信息
     * @return 红色球偶数个数
     */
    private int getOushu(Kaijhm kaijhm) {

        int[] red = kaijhm.toArray();
        int number = 0;

        for (int i: red) {
            if (i % 2 == 0) {
                number++;
            }
        }

        return number;
    }

    /**
     * 计算当前期数与上一期数红色球相同个数
     * @param thisQS 当前期数开奖信息
     * @param lastQS 上期开奖信息
     * @return 红色球相同个数
     */
    private int getEqLast(Kaijhm thisQS, Kaijhm lastQS) {
        int number = 0;
        int[] thisArr = thisQS.toArray();
        int[] lastArr = lastQS.toArray();

        for (int thisRed : thisArr) {
            for (int lastRed : lastArr) {
                if (thisRed == lastRed) {
                    number++;
                }
            }
        }
        return number;
    }

    /**
     * 计算当前期数开奖信息中红色球出现3连号的次数
     * @param kaijhm 当前期数开奖信息
     * @return 红色球出现3连号的次数
     */
    private int getLianxuhm(Kaijhm kaijhm) {
        int[] arr = kaijhm.toArray();
        int number = 0;
        int flag = 0;
        int tmp = 0;

        for (int red : arr) {
            if (flag == 0) {
                flag = red;
                continue;
            } else {
                flag = red;
                if (red - flag == 1) {
                    if (tmp == 0) {
                        tmp ++;
                    } else {
                        number++;
                    }
                } else {
                    tmp = 0;
                }
            }
        }
        return number;
    }


    public static void main(String[] args) {
        AnalyzeService as = new AnalyzeService();
        as.batchInsertAnalyze("2017001");
    }

}
