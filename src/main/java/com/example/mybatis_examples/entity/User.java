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
@TableName("user")
public class User {
    private Long id;
    private String name;
    private String company;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
