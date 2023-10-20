package com.bupt.eights.service.impl;

import com.bupt.eights.dao.AppointmentMapper;
import com.bupt.eights.dao.RoomMapper;
import com.bupt.eights.dao.StudentMapper;
import com.bupt.eights.model.Appointment;
import com.bupt.eights.model.AppointmentStatus;
import com.bupt.eights.model.Room;
import com.bupt.eights.model.Student;
import com.bupt.eights.service.AppointmentService;
import com.bupt.eights.utils.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AppointmentService")
public class AppointmentServiceImpl implements AppointmentService {
    
    @Autowired
    private AppointmentMapper appointmentMapper;
    
    @Autowired
    private RoomMapper roomMapper;
    
    @Autowired
    private StudentMapper studentMapper;
    
    @Override
    public void saveAppointment(Appointment appointment) {
        Student student = studentMapper.findStudentByEmail(ServiceUtil.getEmail());
        Room room = roomMapper.findRoomById(appointment.getRoom().getRoomId());
        
        appointment.setStudent(student);
        appointment.setRoom(room);
        appointmentMapper.save(appointment);
    }
    
    @Override
    public void rescheduleAppointment(Appointment appointment) {
        Appointment appointmentToUpdate = appointmentMapper.findOne(appointment.getAppointmentId());
        appointmentToUpdate.setDate(appointment.getDate());
        appointmentToUpdate.setTime(appointment.getTime());
        appointmentToUpdate.setNotes(appointment.getNotes());
        appointmentToUpdate.setAppointmentStatus(AppointmentStatus.NEW);
    }
    
    @Override
    public Appointment getAppointment(Integer id) {
        return appointmentMapper.findOne(id);
    }
    
    @Override
    public void cancelAppointment(Integer id) {
        Appointment appointment = appointmentMapper.findOne(id);
        updateAppointmentStatus(appointment, AppointmentStatus.CANCELED);
    }
    
    @Override
    public void acceptAppointment(Integer id) {
        Appointment appointment = appointmentMapper.findOne(id);
        updateAppointmentStatus(appointment, AppointmentStatus.ACCEPTED);
    }
    
    @Override
    public void rejectAppointment(Integer id) {
        Appointment appointment = appointmentMapper.findOne(id);
        updateAppointmentStatus(appointment, AppointmentStatus.REJECTED);
    }
    
    @Override
    public void updateAppointment(Appointment appointment) {
        Appointment appointmentToUpdate = appointmentMapper.findOne(appointment.getAppointmentId());
        appointment.setAppointmentStatus(AppointmentStatus.COMPLETE);
        appointmentMapper.save(appointmentToUpdate);
    }
    
    private void updateAppointmentStatus(Appointment appointment, AppointmentStatus status) {
        appointment.setAppointmentStatus(status);
        appointmentMapper.save(appointment);
    }
}
