package com.tangz.shoppingmall.dao;

import com.tangz.shoppingmall.meta.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


public interface UserDao {




    @Select("select * from user where id=#{id}")
    User findById(int id);

    @Select("select * from user where name=#{name}")
    User findByName(String name);

    @Insert("insert into user(name,password,type) values(#{name},#{password},#{type})")
    Boolean addOne(@Param("name") String name, @Param("password")String password, @Param("type") int type);
}
