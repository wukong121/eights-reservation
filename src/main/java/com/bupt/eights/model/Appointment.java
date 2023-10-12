package com.bupt.eights.model;

public class Appointment {
    
    private int privateId;
    
    private String date;
    
    private String time;
    
    private String notes;
    
    private String roomName;
    
    private String studentName;
    
    public void setPrivateId(int privateId) {
        this.privateId = privateId;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public int getPrivateId() {
        return privateId;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getTime() {
        return time;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public String getRoomName() {
        return roomName;
    }
    
    public String getStudentName() {
        return studentName;
    }
}
