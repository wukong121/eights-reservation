package com.bupt.eights.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class Appointment {
    
    private int appointmentId;
    
    private Date date;
    
    private Time time;
    
    private String notes;
    
    private AppointmentStatus appointmentStatus;
    
    private Student student;
    
    private Room room;
}
