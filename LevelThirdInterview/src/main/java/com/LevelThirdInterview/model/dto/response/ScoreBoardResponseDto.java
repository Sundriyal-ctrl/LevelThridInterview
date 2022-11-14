package com.LevelThirdInterview.model.dto.response;

import lombok.Data;

@Data
public class ScoreBoardResponseDto {
    int leaderShipId;
    String gameName;
    String yourName;
    String oponentName;
    int yourScore;
    int oponentScore;
    String winnerName;
}
