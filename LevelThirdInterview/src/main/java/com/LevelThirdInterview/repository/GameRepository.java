package com.LevelThirdInterview.repository;

import com.LevelThirdInterview.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity,Integer> {
    boolean existsByGameName(String gameName);

}
