package com.example.demo.service;
import com.example.demo.model.Player;
import com.example.demo.model.Room;
import com.example.demo.model.enums.GameState;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class RoomService {

   private final RoomRepository roomRepository;

   @Autowired
   public RoomService(RoomRepository roomRepository)
   {
       this.roomRepository = roomRepository;
   }

    public Room createRoom( String owner_id)
    {
        Room room = new Room();
        String rid = UUID.randomUUID().toString();
        room.setRid(rid);
        room.setOwner_id(owner_id);
        Set<String> playerIds = room.getPlayerIds();
       playerIds.add(owner_id);
       room.setPlayerIds(playerIds);
        room.setGameState(GameState.WAITING);
        return  roomRepository.save(room);
    }

    public void deleteRoom(String rid)
    {
        Room room = roomRepository.findById(rid).orElseThrow(() -> new RuntimeException("Room not found"));
        roomRepository.delete(room);
    }

    public List<Room> getAllRooms()
    {
        return roomRepository.findAll();
    }
    public Room getRoomById( String rid)
    {
        return roomRepository.findById(rid).orElseThrow(() -> new RuntimeException(("Room not found")));
    }
}
