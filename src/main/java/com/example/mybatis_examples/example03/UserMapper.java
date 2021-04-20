package com.example.mybatis_examples.example03;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_examples.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select id,name,company from user where company=#{comp}")
    List<User> listByCompany(String comp);

    @Select("select u.* from user u join address a on u.id = a.user_id " +
            "where a.detail=#{detail}")
    List<User> listByDetail(String detail);
}