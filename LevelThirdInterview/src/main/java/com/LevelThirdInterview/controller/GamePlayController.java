package com.LevelThirdInterview.controller;

import com.LevelThirdInterview.model.dto.request.CoordinateRequestDto;
import com.LevelThirdInterview.model.dto.request.FireRequestDto;
import com.LevelThirdInterview.service.GamePlayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/gameplay")
public class GamePlayController {
    @Autowired
    GamePlayServiceImpl gamePlayService;
    @PatchMapping("/move")
    public ResponseEntity move(@Valid @RequestBody CoordinateRequestDto coordinateRequestDto, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return new ResponseEntity(Optional.of(bindingResult.getFieldError("xCoordinate").getDefaultMessage()),HttpStatus.BAD_GATEWAY);
        }else{
        return  new ResponseEntity(Optional.of(gamePlayService.move(coordinateRequestDto)), HttpStatus.OK);
    }}

    @PostMapping("/fire")
    public ResponseEntity fire(@Valid @RequestBody FireRequestDto requestDto,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return new ResponseEntity(Optional.of(bindingResult.getFieldError("y").getDefaultMessage()),HttpStatus.BAD_GATEWAY);
        }
        else {
            return new ResponseEntity(Optional.of(gamePlayService.fire(requestDto)), HttpStatus.OK);
        }}

}
