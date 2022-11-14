package com.LevelThirdInterview.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LeaderShipBoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int leaderShipId;
    String gameName;
    String yourName;
    String oponentName;
    int yourScore;
    int oponentScore;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    GameEntity gameEntity;
}
