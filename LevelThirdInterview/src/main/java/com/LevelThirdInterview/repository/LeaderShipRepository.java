package com.LevelThirdInterview.repository;

import com.LevelThirdInterview.entity.LeaderShipBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderShipRepository extends JpaRepository<LeaderShipBoardEntity,Integer> {
    LeaderShipBoardEntity findByGameName(String gameName);
}
