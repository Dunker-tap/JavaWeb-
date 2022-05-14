package com.ithema.service;

import com.ithema.mapper.BrandMapper;
import com.ithema.pojo.Brand;
import com.ithema.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class BrandService {
    //提升到成员的位置，这样代码只需要写一次就行
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public ArrayList<Brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        //get brandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        ArrayList<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }


    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.close();
    }

    public Brand selectById(int id) {
        SqlSession sqlSession = factory.openSession(true);
        //get brandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public void update(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        //get brandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }
}
