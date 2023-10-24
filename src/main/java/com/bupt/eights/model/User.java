package com.bupt.eights.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.EnumNaming;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String userId;
    
    private String userName;
    
    private String email;
    
    private String password;
    
    private String confirmPassword;

    private String verificationCode;

    private String createTime;
    
    private AuthorityRole authority;
}
