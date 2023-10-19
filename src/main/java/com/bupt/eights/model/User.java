package com.bupt.eights.model;

import lombok.Data;


@Data
public class User {
    
    private int userId;
    
    private String email;
    
    private String password;
    
    private String confirmPassword;
    
    private Boolean enabled;
    
    private Authority authority;
}
