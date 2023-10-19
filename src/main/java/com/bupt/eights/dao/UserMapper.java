package com.bupt.eights.dao;

import com.bupt.eights.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    
    User findUserByEmailAndPassword(@Param(value = "email") String email, @Param(value = "password") String password);

    int insertUser(User user);
    
}
