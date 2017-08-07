package com.felix.lottery.service;

import com.felix.lottery.bean.Kaijhm;
import com.felix.lottery.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: Felix
 * Date: 2017/7/14
 * Time: 15:30
 */
public class KaijhmService {

    public static final String NAMESPACE = "com.felix.lottery.mapping.LotteryMapper";

    public Kaijhm getKaijhmByQS(String kaijsq) {

        String statement = NAMESPACE + ".getKaijhm";

        SqlSession sqlSession = DBUtils.getSqlSession();
        Kaijhm kaijhm = sqlSession.selectOne(statement, kaijsq);
        sqlSession.close();
        return kaijhm;
    }

    public static void main(String[] args) {
        KaijhmService ks = new KaijhmService();
        Kaijhm kaijhm = ks.getKaijhmByQS("2017100");
        if (kaijhm != null) {
            System.out.println(kaijhm.toString());
        }

    }
}
