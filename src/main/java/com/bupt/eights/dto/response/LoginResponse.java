package com.bupt.eights.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResponse implements Serializable {
    
    @Data
    @AllArgsConstructor
    public static class User {
        
        String userName;
        
        String password;
        
    }
    
    private User user;
    
    private String token;
}
