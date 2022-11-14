package com.LevelThirdInterview.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int gameId;
    String gameName;
    String you;
    String oponent;

    @CreatedDate
    LocalDateTime localDateTime;
    @ManyToOne
    @JsonBackReference
    PlayerEntity playerEntity;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    LeaderShipBoardEntity leaderShipBoardEntity;


}
