package com.future.mapper;

import com.future.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface BrandMapper {

    ArrayList<Brand> selectAll();

    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    @ResultMap("brandResultMap")
    void add(Brand brand);

    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description=#{description},status=#{status} where id = #{id}")
    void update(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    void deleteById(int id);
}
