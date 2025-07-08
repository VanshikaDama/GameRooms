package com.example.demo.service;

import com.example.demo.model.Player;


import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Room;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class PlayerService
{
    private final PlayerRepository playerRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository,RoomRepository roomRepository)
    {
        this.playerRepository =  playerRepository;
        this.roomRepository = roomRepository;
    }

    public Player createPlayer(String name)
    {
        Player player = new Player();
        String pid = UUID.randomUUID().toString();
        player.setPid(pid);
        player.setName(name);
        player.setRoom_id(null);
        player.setScore(0);
        return playerRepository.save(player);
    }

    public Player addPlayerToRoom(String pid, String rid)
    {
        Room room = roomRepository.findById(rid).orElseThrow(
                () -> new RuntimeException("Room not found"));
        Player player = playerRepository.findById(pid).orElseThrow(()->new RuntimeException("PLayer not found"));
        player.setRoom_id(rid);
        Set<String> playerIds = room.getPlayerIds();
        playerIds.add(pid);
        roomRepository.save(room);
        return playerRepository.save(player);

    }

    public Player updateScore(String pid, int score)
    {
        Player player = playerRepository.findById(pid).orElseThrow(
                () -> new RuntimeException("Room not found")
        );
        player.setScore(score);
        return playerRepository.save(player);
    }

    public void removePlayer(String pid, String rid)
    {
        Player player = playerRepository.findById(pid).orElseThrow(() -> new RuntimeException("PLayer not found"));
        Room room = roomRepository.findById(rid).orElseThrow(
                () -> new RuntimeException("Room not found")
        );
        room.getPlayerIds().removeIf(playerId -> playerId.equals(pid));
        player.setRoom_id(null);
        player.setScore(0);
        playerRepository.save(player);
        roomRepository.save(room);
    }

    public Player getPlayerById(String pid)
    {
       return playerRepository.findById(pid).orElseThrow(() -> new RuntimeException("Player not found"));
    }

    public List<Player> getAllPlayers()
    {
        return playerRepository.findAll();
    }
}
