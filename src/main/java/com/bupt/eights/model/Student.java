package com.bupt.eights.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    
    private int studentId;
    
    private String firstName;
    
    private String lastName;
    
    private String Gender;
    
    private Long phoneNumber;
    
    private User user;
}
