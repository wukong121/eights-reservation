package com.bupt.eights.service;

import com.bupt.eights.dao.StudentMapper;
import com.bupt.eights.model.Appointment;
import com.bupt.eights.model.Authority;
import com.bupt.eights.model.AuthorityRole;
import com.bupt.eights.model.Student;
import com.bupt.eights.utils.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentMapper studentMapper;
    
    @Override
    public void saveStudent(Student student) {
        student.getUser().setAuthority(AuthorityRole.ROLE_STUDENT);
        String encodedPassword = ServiceUtil.hashPassword(student.getUser().getPassword());
        student.getUser().setPassword(encodedPassword);
        
    }
    
    @Override
    public Student findStudentByPhoneNumber(Long phoneNumber) {
        return null;
    }
    
    @Override
    public Map<Date, List<Appointment>> getUpcomingAppointment(List<Appointment> appointmentList) {
        return null;
    }
    
    @Override
    public Map<Date, List<Appointment>> getOverdueAppointment(List<Appointment> appointmentList) {
        return null;
    }
}
