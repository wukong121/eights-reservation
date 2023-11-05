package com.bupt.eights.service;

import com.bupt.eights.dto.request.LoginRequest;
import com.bupt.eights.dto.request.RegisterRequest;
import com.bupt.eights.dto.response.HttpResponse;
import com.bupt.eights.dto.response.LoginResponse;
import com.bupt.eights.model.User;

public interface AuthenticateService {
    
    User createUser(RegisterRequest registerRequest);
    
    HttpResponse<LoginResponse> authenticate(LoginRequest loginRequest);
    
}
