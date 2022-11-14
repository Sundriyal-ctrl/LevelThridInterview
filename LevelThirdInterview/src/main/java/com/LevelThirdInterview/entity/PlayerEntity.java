package com.LevelThirdInterview.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int playerId;
    String playerName;
    String playerNameInsideGame;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "playerEntity")
    @JsonManagedReference
    List<GameEntity> gameEntityList=new ArrayList<>();
    @OneToOne(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    CoordinateEntity coordinateEntity;
}
