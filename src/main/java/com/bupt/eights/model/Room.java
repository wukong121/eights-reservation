package com.bupt.eights.model;

import lombok.Data;


@Data
public class Room {
    
    private int roomId;
    
    private String name;
    
    private String address;
    
    private Category category;
    
    private Specialization specialization;
}
