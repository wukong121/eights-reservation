package com.bupt.eights.dao;

import com.bupt.eights.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    
    User findUserByEmailAndPassword(@Param(value = "email") String email, @Param(value = "password") String password);
    
}
