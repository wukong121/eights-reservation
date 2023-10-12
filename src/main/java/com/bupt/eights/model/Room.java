package com.bupt.eights.model;

public class Room {
    
    private int roomId;
    
    private String name;
    
    private String address;
    
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getRoomId() {
        return roomId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
}
