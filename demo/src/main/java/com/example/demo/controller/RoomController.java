package com.example.demo.controller;

import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.config.Paths;

import java.util.List;

@Controller
@RequestMapping(Paths.RoomPath)
public class RoomController {

    private final RoomRepository roomRepository;
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService, RoomRepository roomRepository)
    {
        this.roomService = roomService;
        this.roomRepository = roomRepository;
    }

    @GetMapping("/room")
    public List<Room> getAllRooms()
    {
        return roomService.getAllRooms();
    }

}
