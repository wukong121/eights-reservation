package com.bupt.eights.model;

public class Student {
    
    private int studentId;
    
    private String name;
    
    private Long phoneNumber;
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public Long getPhoneNumber() {
        return phoneNumber;
    }
}
