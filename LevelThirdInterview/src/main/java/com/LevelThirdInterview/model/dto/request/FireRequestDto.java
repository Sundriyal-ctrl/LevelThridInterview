package com.LevelThirdInterview.model.dto.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class FireRequestDto {
    @Min(value=-10,message="coordinate x greater than or equals to -10")
    @Max(value=10,message = "Coordinate x less than or equals to 10")
    int x;
    @Min(value=-10,message="coordinate y greater than or equals to -10")
    @Max(value=10,message = "Coordinate y less than or equals to 10")
    int y;
    String gameName;
    int yourid;
}
