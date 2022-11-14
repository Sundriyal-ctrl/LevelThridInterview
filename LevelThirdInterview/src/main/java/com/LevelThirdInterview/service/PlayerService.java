package com.LevelThirdInterview.service;

import com.LevelThirdInterview.entity.GameEntity;
import com.LevelThirdInterview.entity.LeaderShipBoardEntity;
import com.LevelThirdInterview.entity.PlayerEntity;
import com.LevelThirdInterview.exception.PlayerIsAlreadyExitsException;
import com.LevelThirdInterview.exception.gameIsAlreadyExitsException;
import com.LevelThirdInterview.model.dto.request.GameRequestDto;
import com.LevelThirdInterview.model.dto.request.PlayerRequestDto;
import com.LevelThirdInterview.repository.GameRepository;
import com.LevelThirdInterview.repository.LeaderShipRepository;
import com.LevelThirdInterview.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LeaderShipRepository leaderShipRepository;
    public PlayerEntity createPlayer(PlayerRequestDto playerRequestDto)
    {
        if(!playerRepository.existsByPlayerNameInsideGame(playerRequestDto.getPlayerNameInsideGame()))
        {
            PlayerEntity playerEntity=modelMapper.map(playerRequestDto,PlayerEntity.class);
            return playerRepository.save(playerEntity);
        }
        else {
            throw new PlayerIsAlreadyExitsException("Player with name "+playerRequestDto.getPlayerNameInsideGame()+" is already Exits");
        }
    }

    public GameEntity createGame(GameRequestDto gameRequestDto)
    {
         if(!gameRepository.existsByGameName(gameRequestDto.getGameName()))
         {
             LeaderShipBoardEntity leaderShipBoardEntity=new LeaderShipBoardEntity();

             GameEntity gameEntity=modelMapper.map(gameRequestDto,GameEntity.class);

             PlayerEntity playerEntity=playerRepository.findById(gameRequestDto.getPlayerId()).get();

             gameEntity.setPlayerEntity(playerEntity);



             leaderShipBoardEntity.setGameEntity(gameEntity);

             leaderShipBoardEntity.setGameName(gameRequestDto.getGameName());

             leaderShipBoardEntity.setYourName(gameRequestDto.getYou());

             leaderShipBoardEntity.setOponentName(gameRequestDto.getOponent());

             leaderShipBoardEntity.setOponentScore(100);

             leaderShipBoardEntity.setYourScore(100);

             gameEntity.setLeaderShipBoardEntity(leaderShipBoardEntity);

             playerEntity.getGameEntityList().add(gameEntity);

             playerRepository.save(playerEntity);

             leaderShipRepository.save(leaderShipBoardEntity);

             return gameEntity;

         }
         else {
             throw new gameIsAlreadyExitsException("Game is already Exits");
         }
    }

}
