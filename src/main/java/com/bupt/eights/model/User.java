package com.bupt.eights.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    
    private int userId;
    
    private String email;
    
    private String password;
    
    private String confirmPassword;
    
    private Boolean enabled;
    
}
