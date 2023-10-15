package com.bupt.eights.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Authority {
    
    private int id;
    
    private String email;
    
    private AuthorityRole authorityRole;
    
    private User user;
}
