package com.example.demo.controller;



import com.example.demo.config.Paths;
import com.example.demo.model.Player;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.PlayerService;
import com.example.demo.repository.PlayerRepository;


import java.util.List;

@RestController
@RequestMapping( Paths.PlayerPath)
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerRepository playerRepository, PlayerService playerService)
    {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }


    @GetMapping("/getAll")
    public  List<Player> getAllRooms()
    {
        return playerService.getAllPlayers();
    }

    @PostMapping("/create")
    public void createPlayer()
    {
     Player newplayer = playerService.createPlayer("abc");
     System.out.println(newplayer);
    }

}
