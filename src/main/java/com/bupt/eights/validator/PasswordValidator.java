package com.bupt.eights.validator;

import com.bupt.eights.model.Student;
import com.bupt.eights.utils.ServiceConstants;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PasswordValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if (!student.getUser().getPassword().equals(student.getUser().getConfirmPassword())) {
            errors.rejectValue("user.password", ServiceConstants.PASSWORD_NOTMATCH_VALIDATION);
        }
    }
}
