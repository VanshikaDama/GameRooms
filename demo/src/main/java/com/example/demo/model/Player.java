package com.example.demo.model;
import jakarta.persistence.*;


@Entity
@Table

public class Player {


    @Id
    private String pid;

    private int score;
    private String name;
    private String room_id;
//    @ManyToOne
//    @JoinColumn(name="room_id")
//    private Room room;


    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}

