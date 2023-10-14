package com.bupt.eights.dao;

import com.bupt.eights.model.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    
    Student findStudentByPhoneNumber(@Param("phoneNumber") Long phoneNumber);
    
}
