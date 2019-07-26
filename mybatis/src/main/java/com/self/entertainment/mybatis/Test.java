package com.self.entertainment.mybatis;

import com.self.entertainment.mybatis.pojo.TbChannel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {

        SqlSessionFactory sessionFactory = null;
        String resource = "MybatisConfig.xml";
        try {
            //SqlSessionFactoryBuilder读取配置文件
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources
                    .getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
//通过SqlSessionFactory获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        System.out.println();
        sqlSession.getMapper(TbChannel.class);

    }
}
