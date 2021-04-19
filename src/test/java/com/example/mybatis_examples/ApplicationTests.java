package com.example.mybatis_examples;

import com.example.mybatis_examples.example02.Mapper02;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


/*
* Spring-test会对对事务进行回滚。
* 为了使测试数据不对数据库造成污染，
* 在使用Spring-test进行的单元测试的时候，
* 默认会对事务进行回滚(插入的数据会在测试成功后自动删除)，
* 即@Rollback 默认是true，
* 如果想要测试数据不回滚，可设置@Rollback(value = false) 。
* */
@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
class ApplicationTests {

    @Autowired   //注入预测试的组件
    public Mapper02 mapper02;


//    @Test
//    public void addUser_test(){
//        User user = new User();     //添加对象
//        user.setId(1L);             //添加属性
//        user.setName("pzc");
//        user.setCompany("facebook");
//        mapper01.insert(user);  //调用接口中的方法
//    }
//
//    @Test
//    public void addAddress_test(){
//        Address address = new Address();     //添加对象
//        address.setId(1L);
//        address.setDetail("985");
//        address.setUserId(1L);
//        mapper01.insert(address);  //调用接口中的方法
//    }

//    @Test
//    public void list_test(){
//        for (User user : mapper01.list()) {
//            log.debug("{}/{}/{}",user.getName(),user.getCompany(),
//                    user.getCreateTime());
//        }
//    }
//    @Test
//    public void get_test(){
//        User user = mapper01.get(1L);
//        log.debug("{}/{}",user.getName(),user.getCreateTime());
//    }

    @Test
    public void addUser_test1(){
        User user = new User();
        user.setName("SUN");
        user.setCompany("amazon");//无需手动设置主键值，默认雪花算法生成
//        mapper02.insert(user);// UserMapper02接口中没声明方法，继承BaseMapper
        // 接口，从而实现CURD操作
    }
    @Test
    public void update_test2(){
        Address address = new Address();
        address.setId(1L);
        address.setCreateTime(LocalDateTime.now());
        address.setDetail("111");
        mapper02.updateById(address);
//        LocalDateTime localDateTime =
//                new LocalDateTime(LocalDate.of(2000, 10, 10),
//                        LocalTime.MAX);
//        System.out.println();

    }

}
