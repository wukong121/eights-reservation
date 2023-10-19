package com.bupt.eights.model;

import lombok.Data;


@Data
public class Authority {
    
    private int id;
    
    private String email;
    
    private AuthorityRole authorityRole;
    
    private User user;
}
