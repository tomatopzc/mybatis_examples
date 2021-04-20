package com.example.mybatis_examples;

import com.example.mybatis_examples.entity.User;
import com.example.mybatis_examples.example03.UserMapper;
import com.example.mybatis_examples.example04.AddressDTO04;
import com.example.mybatis_examples.example04.AddressMapper04;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;


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

//    @Autowired   //注入预测试的组件
//    public Mapper02 mapper02;


    @Autowired
    public UserMapper userMapper;
//
//
////    @Test
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
//
//    @Test
//    public void addUser_test1(){
//        User user = new User();
//        user.setName("SUN");
//        user.setCompany("amazon");//无需手动设置主键值，默认雪花算法生成
////        mapper02.insert(user);// UserMapper02接口中没声明方法，继承BaseMapper
//        // 接口，从而实现CURD操作
//    }
//    @Test
//    public void update_test2(){
//        Address address = new Address();
//        address.setId(1L);
//        address.setCreateTime(LocalDateTime.now());
//        address.setDetail("111");
//        mapper02.updateById(address);
//        LocalDateTime localDateTime =
//             new LocalDateTime(LocalDate.of(2000, 10, 10),
//                       LocalTime.MAX);
//        System.out.println();

//    }

    @Test
    public void update_test(){
        User user =User.builder()
                .id(1383791836138369026L)
                .company("nike")
                .build();
        userMapper.updateById(user);

    }

    @Test
    public void list_test1(){
        //ByMap 方法,键为字段名称
        List<User> users = userMapper.selectByMap(Map.of("company","nike"));
        for (User user : users){
            log.debug(user.getName());
        }/*基于MP通用方法的属性查询,返回记录的全部数据封装
        自动动编写方法及SQL语句,灵活指定所数据
        自动创建List接口类型对象
        */
    }

    @Test  //在UserMapper里显示声明查询语句,需创建List接口
    public void list_test2(){
      List<User> users = userMapper.listByCompany("nike");
        for (User user : users) {
            log.debug(user.getName());
            log.debug(user.getCompany());
            log.debug("{}",user.getId());  //log.debug()只能输出字符串
            log.debug(user.getId().toString());//方法2
        }
    }

    @Test
    public void list_ByDetail(){
        for (User user : userMapper.listByDetail("222")) {
            log.debug("{}/{}/{}", user.getId(),user.getName(),user.getCreateTime());
        }
    }

    //example04
    @Autowired
    public AddressMapper04 mapper04;
    @Test
    public void example04(){
        for (AddressDTO04 a : mapper04.list("222")) {
            log.debug("{}",a);
        }
    }

}
