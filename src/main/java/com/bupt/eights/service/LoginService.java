package com.bupt.eights.service;

import com.bupt.eights.dto.RegisterDTO;
import com.bupt.eights.model.User;
import org.springframework.stereotype.Service;

public interface LoginService {
    
    int createUser(RegisterDTO registerDTO);
    
}
