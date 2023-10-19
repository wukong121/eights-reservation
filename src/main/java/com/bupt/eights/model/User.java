package com.bupt.eights.model;

import lombok.Data;


@Data
public class User {

    private String id;
    
    private String userName;
    
    private String email;
    
    private String password;
    
    private String confirmPassword;

    private String verificationCode;

    private String createTime;
    
    private Boolean enabled;
    
    private Authority authority;
}
