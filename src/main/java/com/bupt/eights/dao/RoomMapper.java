package com.bupt.eights.dao;

import com.bupt.eights.model.Room;
import com.bupt.eights.model.Specialization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomMapper {
    
    Room findRoomByAddress(@Param(value = "address") String address);
    
    Room findRoomByName(@Param(value = "name") String name);
    
    Room findRoomById(@Param(value = "roomId") Integer roomId);
    
    List<Room> findRoomsBySpecialization(@Param(value = "specialization") Specialization specialization);
    
    void save(@Param(value = "room") Room room);
    
}
