package com.bupt.eights.service;

import com.bupt.eights.dao.UserMapper;
import com.bupt.eights.dto.RegisterDTO;
import com.bupt.eights.model.User;
import com.bupt.eights.utils.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
    
    UserMapper userMapper;
    
    @Override
    public int createUser(RegisterDTO userDTO) {
        User user = ServiceUtil.mapRegiterDTOToRegister(userDTO);
        // set id
        String uuid = UUID.randomUUID().toString();
        user.setId(uuid);
        // set createTime
        Date now = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreateTime(date.format(now));
        
        return userMapper.insertUser(user);
    }
}
