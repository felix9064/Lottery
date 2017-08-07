package com.felix.lottery.test;

import com.felix.lottery.bean.Kaijhm;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

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
        // Reader reader = Resources.getResourceAsReader(resource);
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(true);

        /**
         * 映射sql的标识字符串com.felix.lottery.mapping.LotteryMapper.getKaijhm
         * getKaijhm是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.felix.lottery.mapping.LotteryMapper.getKaijhm";//映射sql的标识字符串

        //执行查询返回一个唯一user对象的sql
        Kaijhm ssq = session.selectOne(statement, "2017074");
        System.out.println(ssq.toString());
        session.close();
    }
}
