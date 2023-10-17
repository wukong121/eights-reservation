package com.bupt.eights.utils;

import com.bupt.eights.model.Appointment;
import com.bupt.eights.model.AppointmentStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceUtil {
    
    private static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    
    public static Map<Date, List<Appointment>> mapAppointmentFromList(List<Appointment> appointmentList,
            boolean isPast) {
        Map<Date, List<Appointment>> appointmentMap = new HashMap<>(30); // initial a month
        if (appointmentList.isEmpty()) {
            return appointmentMap;
        }
        Date now = getCurrentDate();
        for (Appointment appointment : appointmentList) {
            List<Appointment> appointments;
            if (appointmentMap.containsKey(appointment.getDate())) {
                appointments = appointmentMap.get(appointment.getDate());
            } else {
                appointments = new ArrayList<>(16);
            }
            if (!appointment.getAppointmentStatus().equals(AppointmentStatus.CANCELED)
                    && now.after(appointment.getDate()) == isPast) {
                appointments.add(appointment);
                appointmentMap.put(appointment.getDate(), appointments);
            }
        }
        return appointmentMap;
    }
    
    public static String hashPassword(String rawPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(rawPassword);
    }
    
    public static String getEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
}
