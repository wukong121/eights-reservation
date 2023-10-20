package com.bupt.eights.Controller;

import com.bupt.eights.dto.Result;
import com.bupt.eights.model.Appointment;
import com.bupt.eights.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

    @GetMapping("/users/{useId}/appointments")
    public Result viewAppointment(@PathVariable int userId){
        return adminService.viewAppointments(userId);
    }


}
