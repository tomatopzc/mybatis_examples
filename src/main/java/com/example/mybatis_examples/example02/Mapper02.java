package com.example.mybatis_examples.example02;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_examples.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Mapper02 extends BaseMapper<User> {
}
