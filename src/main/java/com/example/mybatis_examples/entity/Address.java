package com.example.mybatis_examples.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@TableName("address")
public class Address {
    private Long id;
    private String detail;
    private Long userId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
