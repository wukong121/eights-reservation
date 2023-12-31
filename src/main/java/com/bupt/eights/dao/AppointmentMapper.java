package com.bupt.eights.dao;

import com.bupt.eights.model.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppointmentMapper {
    
    Appointment findOne(@Param(value = "appointmentId") Integer id);
    
    void save(@Param(value = "appointment") Appointment appointment);
    
}
