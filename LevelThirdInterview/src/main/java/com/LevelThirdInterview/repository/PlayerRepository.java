package com.LevelThirdInterview.repository;

import com.LevelThirdInterview.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity,Integer> {
    boolean existsByPlayerNameInsideGame(String playerNameInsideGame);

}
