package com.example.mybatis_examples.example04;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddressDTO04 {
    private String name;
    private String company;
    private LocalDateTime UserCreatTime;
    private Long id;
    private String detail;
    private Long userId;
    private LocalDateTime AdressCreatTime;

}
