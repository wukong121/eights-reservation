package com.bupt.eights.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Appointment {
    
    private int privateId;
    
    private String date;
    
    private String time;
    
    private String notes;
    
    private String roomName;
    
    private String studentName;
    
    private AppointmentStatus status = AppointmentStatus.NEW;
}
