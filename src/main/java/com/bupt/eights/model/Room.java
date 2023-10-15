package com.bupt.eights.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
    
    private int roomId;
    
    private String address;
    
    private Category category;
    
    private Specialization specialization;
}
