package com.bupt.eights.service;

import com.bupt.eights.model.Appointment;
import com.bupt.eights.model.Student;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentService {
    
    void saveStudent(Student student);
    
    Student findStudentByPhoneNumber(Long phoneNumber);
    
    Map<Date, List<Appointment>> getUpcomingAppointment(List<Appointment> appointmentList);
    
    Map<Date, List<Appointment>> getOverdueAppointment(List<Appointment> appointmentList);
    
}
