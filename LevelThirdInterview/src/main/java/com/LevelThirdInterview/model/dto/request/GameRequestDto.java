package com.LevelThirdInterview.model.dto.request;

import lombok.Data;

@Data
public class GameRequestDto {
    String gameName;
    String you;
    String oponent;

    int playerId;
}
