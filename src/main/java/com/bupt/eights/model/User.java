package com.bupt.eights.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String userId;
    
    private String userName;
    
    private String email;
    
    private String phoneNumber;
    
    private String gender;
    
    private String nickName;
    
    private String password;

    private String createTime;
    
    private AuthorityRole authority;
}
