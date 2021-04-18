package com.example.mybatis_examples.example01;

import com.example.mybatis_examples.entity.Address;
import com.example.mybatis_examples.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface Mapper01 {
    @Insert("insert into user(id, name, company) VALUES (#{id},#{name}," +
            "#{company})")
    void insert(User user);

    @Insert("insert into address(id, detail, user_id) VALUES (#{id}," +
            "#{detail},#{userId})")
    void insert(Address address);

    @Select("select * from user")
    List<User> list();

    @Select("select * from user u where u.id=#{iii}")
    User get(@Param("iii") long uid);
    /*@Param 方法参数注解,声明sql语句中对应参数(iii),否则必须写uid,与形参名一致

    首先解释一下为毛要用这个东西

 当在查询的时候，一个参数的时候，在直接在入参中写入就可以了，但是当两个参数的时候，怎么办？

 两种办法：第一用Map ,第二：就用@param，[可读性比较好，参数少的时候]

注意：当参数为2-5个时候，用@param最佳，当大于5的时候，肯定会选择map了

      * */




}
