package com.self.entertainment.mybatis.sharding;

import com.self.entertainment.mybatis.pojo.User;
import com.self.entertainment.mybatis.repository.TbUserMapper;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author AmazingZ
 * @date 2019/7/23 10:08
 */
public class TestMybatis {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("MybatisConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TbUserMapper tbUserMapper = sqlSession.getMapper(TbUserMapper.class);
    }

    public static class Test implements MethodInterceptor{
        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            return null;
        }
    }
}
