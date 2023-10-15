package com.bupt.eights.dao;

import com.bupt.eights.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {
    
    Student findStudentByPhoneNumber(@Param("phoneNumber") Long phoneNumber);
    
}
