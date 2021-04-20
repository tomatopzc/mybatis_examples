package com.example.mybatis_examples.example03;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_examples.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
}