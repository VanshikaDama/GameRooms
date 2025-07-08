package com.example.demo.model;
import com.example.demo.model.enums.GameState;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Room {

    @Id
    private String rid;
    private String owner_id;
    private Set<String> playerIds;

    @Enumerated(EnumType.STRING)
    private GameState gameState;

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Set<String> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(Set<String> playerIds) {
        this.playerIds = playerIds;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}

