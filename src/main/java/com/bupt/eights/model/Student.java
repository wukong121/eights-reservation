package com.bupt.eights.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Student {
    
    private int studentId;
    
    private String firstName;
    
    private String lastName;
    
    private String Gender;
    
    private Long phoneNumber;
    
    private User user;
}
