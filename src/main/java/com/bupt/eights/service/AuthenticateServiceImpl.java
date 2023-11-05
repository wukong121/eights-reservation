package com.bupt.eights.service;

import com.bupt.eights.dao.UserMapper;
import com.bupt.eights.dto.request.LoginRequest;
import com.bupt.eights.dto.request.RegisterRequest;
import com.bupt.eights.dto.response.HttpResponse;
import com.bupt.eights.dto.response.LoginResponse;
import com.bupt.eights.model.User;
import com.bupt.eights.utils.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
    
    @Autowired
    UserMapper userMapper;
    
    @Override
    public User createUser(RegisterRequest request) {
        User user = ServiceUtil.mapRequestToRegister(request);
        userMapper.insertUser(user);
        return user;
    }
    
    @Override
    public HttpResponse<LoginResponse> authenticate(LoginRequest loginRequest) {
        HttpResponse<LoginResponse> response = new HttpResponse<>();
        String userName = loginRequest.getUserName();
        String password = loginRequest.getPassword();
        User user = userMapper.findUserByUserName(userName);
        if (user == null) {
            response.setStatus("failed");
            response.setCode(404);
            response.setMessage("Username not found!");
            return response;
        }
        if (!Objects.equals(user.getPassword(), loginRequest.getPassword())) {
            response.setStatus("failed");
            response.setCode(401);
            response.setMessage("Username or password error!");
            return response;
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUser(new LoginResponse.User(userName, password));
        response.setStatus("success");
        response.setCode(200);
        response.setMessage("Login successfully!");
        response.setData(loginResponse);
        return response;
    }
}
