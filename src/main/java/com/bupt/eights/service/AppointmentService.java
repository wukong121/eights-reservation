package com.bupt.eights.service;

import com.bupt.eights.model.Appointment;


public interface AppointmentService {
    
    void saveAppointment(Appointment appointment);
    
    void rescheduleAppointment(Appointment appointment);
    
    Appointment getAppointment(Integer id);
    
    void cancelAppointment(Integer id);
    
    void acceptAppointment(Integer id);
    
    void rejectAppointment(Integer id);
    
    void updateAppointment(Appointment appointment);
    
}
