package com.future.service;

import com.future.mapper.UserMapper;
import com.future.pojo.User;
import com.future.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }

    /**
     * 注册方法
     *
     * @param user
     * @return
     */
    public boolean register(User user) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.selectByUsername(user.getUsername());

        if (u == null) {
            //用户名不存在可以注册
            mapper.add(user);
            sqlSession.commit();
        }
        //释放资源
        sqlSession.close();
        //直接返回u == null，因为它是一个boolean类型，减少了代码量
        return u == null;
    }
}
