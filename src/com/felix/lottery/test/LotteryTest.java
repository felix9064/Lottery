package com.felix.lottery.test;

import com.felix.lottery.bean.DoubleColorBall;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: Felix
 * Date: 2017/6/22
 * Time: 21:15
 */
public class LotteryTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        /**
         * 映射sql的标识字符串com.felix.lottery.mapping.LotteryMapper.getKaijhm
         * getKaijhm是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.felix.lottery.mapping.LotteryMapper.getKaijhm";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        DoubleColorBall ssq = session.selectOne(statement, "2017070");
        System.out.println(ssq.toString());
    }
}
