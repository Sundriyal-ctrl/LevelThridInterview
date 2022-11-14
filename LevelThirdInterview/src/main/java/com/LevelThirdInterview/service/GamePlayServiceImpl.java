package com.LevelThirdInterview.service;

import com.LevelThirdInterview.entity.CoordinateEntity;
import com.LevelThirdInterview.entity.LeaderShipBoardEntity;
import com.LevelThirdInterview.entity.PlayerEntity;
import com.LevelThirdInterview.exception.OponentIsAlreadyInYourCoordinate;
import com.LevelThirdInterview.model.dto.request.CoordinateRequestDto;
import com.LevelThirdInterview.model.dto.request.FireRequestDto;
import com.LevelThirdInterview.model.dto.response.ScoreBoardResponseDto;
import com.LevelThirdInterview.repository.CoordinateRepository;
import com.LevelThirdInterview.repository.GameRepository;
import com.LevelThirdInterview.repository.LeaderShipRepository;
import com.LevelThirdInterview.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GamePlayServiceImpl {
  @Autowired
  GameRepository gameRepository;

  @Autowired
  PlayerRepository playerRepository;

  @Autowired
  CoordinateRepository coordinateRepository;

  @Autowired
  LeaderShipRepository leaderShipRepository;

  @Autowired
  ModelMapper modelMapper;

  public  String move(CoordinateRequestDto coordinateRequestDto)
  {
      List<CoordinateEntity> list=coordinateRepository.findAll();
      List<CoordinateEntity> list1=list.stream().filter(s->s.getYCoordinate()!=coordinateRequestDto.getXCoordinate() && s.getYCoordinate()!=coordinateRequestDto.getYCoordinate()).collect(Collectors.toList());
      if(list1.size()<=0) {
        CoordinateEntity coordinateEntity=modelMapper.map(coordinateRequestDto,CoordinateEntity.class);
        PlayerEntity playerEntity=playerRepository.getById(coordinateRequestDto.getPlayerId());
        coordinateEntity.setPlayerEntity(playerEntity);
        if(coordinateRequestDto.getYCoordinate()<0 && coordinateRequestDto.getYCoordinate()>0)
          return "You moved top left";
        else if(coordinateRequestDto.getYCoordinate()>0 && coordinateRequestDto.getYCoordinate()<0)
          return "you moved right down";
      }
      else {
        throw new OponentIsAlreadyInYourCoordinate("your oponent is already in your given position and he will kill you");
      }
    return null;
  }

  public ResponseEntity fire(FireRequestDto requestDto)
  {
      List<CoordinateEntity> list=coordinateRepository.findAll();
      List<CoordinateEntity> list1=list.stream().filter(s->s.getYCoordinate()!=requestDto.getX() && s.getYCoordinate()!=requestDto.getY()).collect(Collectors.toList());

      if(list1.size()>=0)
     {
         CoordinateEntity coordinateEntity=list1.get(0);
         LeaderShipBoardEntity leaderShipBoardEntity=leaderShipRepository.findByGameName(requestDto.getGameName());
         if(leaderShipBoardEntity.getOponentScore()>0) {
           leaderShipBoardEntity.setOponentScore(leaderShipBoardEntity.getOponentScore() - 20);
         }
         if(leaderShipBoardEntity.getYourScore()<=80) {
           leaderShipBoardEntity.setYourScore(leaderShipBoardEntity.getYourScore() + 20);
         }
         else if(leaderShipBoardEntity.getOponentScore()<=0 && leaderShipBoardEntity.getYourScore()>0) {
            ScoreBoardResponseDto scoreBoardResponseDto=modelMapper.map(leaderShipBoardEntity, ScoreBoardResponseDto.class);
            scoreBoardResponseDto.setWinnerName(leaderShipBoardEntity.getYourName());
            return new ResponseEntity(Optional.of(scoreBoardResponseDto), HttpStatus.OK);
         }
         else if(leaderShipBoardEntity.getYourScore()<=0 && leaderShipBoardEntity.getOponentScore()>0) {
           ScoreBoardResponseDto scoreBoardResponseDto=modelMapper.map(leaderShipBoardEntity, ScoreBoardResponseDto.class);
           scoreBoardResponseDto.setWinnerName(leaderShipBoardEntity.getOponentName());
           return new ResponseEntity(Optional.of(scoreBoardResponseDto), HttpStatus.OK);
         }
         leaderShipRepository.save(leaderShipBoardEntity);
         coordinateEntity.setXCoordinate(requestDto.getX());
         coordinateEntity.setYCoordinate(requestDto.getY());
         coordinateRepository.save(coordinateEntity);
       return new ResponseEntity(Optional.of("Impresive"), HttpStatus.OK);
     }
     else {
       return new ResponseEntity(Optional.of("Oops You Miss the hit"), HttpStatus.OK);
     }
  }

}
