package com.LevelThirdInterview.controller;

import com.LevelThirdInterview.model.dto.request.GameRequestDto;
import com.LevelThirdInterview.model.dto.request.PlayerRequestDto;
import com.LevelThirdInterview.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {
  @Autowired
  PlayerService playerService;

  @PostMapping("/createPlayer")
  public ResponseEntity createPlayer(@RequestBody PlayerRequestDto playerRequestDto)
  {
      return new ResponseEntity(Optional.of(playerService.createPlayer(playerRequestDto)), HttpStatus.CREATED);
  }

  @PostMapping("/createGame")
  public ResponseEntity createGamePlay(@RequestBody GameRequestDto gameRequestDto)
  {
      return new ResponseEntity(Optional.of(playerService.createGame(gameRequestDto)), HttpStatus.CREATED);
  }
}
