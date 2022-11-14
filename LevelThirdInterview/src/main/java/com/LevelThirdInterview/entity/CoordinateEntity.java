package com.LevelThirdInterview.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CoordinateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int coordinateId;
    int xCoordinate;
    int yCoordinate;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    PlayerEntity playerEntity;
}
