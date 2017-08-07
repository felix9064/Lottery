package com.felix.lottery.utils;

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
 * Date: 2017/7/14
 * Time: 10:42
 */
public class DBUtils {

    public static final String CONFIG = "mybatis-config.xml";

    public static SqlSession getSqlSession() {

        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(CONFIG);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "development");
        return sqlSessionFactory.openSession(true);
    }
}
