package com.example.mybatis_examples.example04;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_examples.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AddressMapper04 extends BaseMapper {
    @Select("select *,u.create_time userCreatTime,a.id id, " +
            "a.create_time addressCreatTime " +
            " from address a join user u " +
            "on a.user_id = u.id where a.detail=#{detail}")
    List<AddressDTO04> list(String detail);
}
