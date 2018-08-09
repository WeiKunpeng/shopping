package com.tangz.shoppingmall.dao;

import com.tangz.shoppingmall.meta.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public interface UserDao {
    @Select("select * from user where id=#{id}")
    User findById(int id);

    @Select("select * from user where name=#{name}")
    User findByName(String name);
}
