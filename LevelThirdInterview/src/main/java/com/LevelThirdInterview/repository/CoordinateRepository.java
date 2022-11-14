package com.LevelThirdInterview.repository;

import com.LevelThirdInterview.entity.CoordinateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateRepository extends JpaRepository<CoordinateEntity,Integer> {
    //boolean existsByXCoordinateAndYCoordinate(int xCoordinate, int yCoordinate);


   // CoordinateEntity findByYCoordinateAndXCoordinate(int yCoordinate, int xCoordinate);


}
