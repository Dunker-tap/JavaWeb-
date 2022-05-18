package com.future.service;

import com.future.mapper.BrandMapper;
import com.future.pojo.Brand;
import com.future.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class BrandService {
    //提升到成员变量的位置，这样的好处是：代码只需要写一次就能多次复用
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询全部
     *
     * @return
     */
    public ArrayList<Brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        ArrayList<Brand> brands = mapper.selectAll();
        //注意关闭sqlSession
        sqlSession.close();
        return brands;
    }

    /**
     * 添加数据
     *
     * @param brand
     */

    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.close();
    }

    /**
     * 通过id查询用户全部信息
     *
     * @param id
     * @return
     */
    public Brand selectById(int id) {
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    /**
     * 修改字段数据
     *
     * @param brand
     */
    public void update(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        //get brandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除记录
     *
     * @param id
     */
    public void delete(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
