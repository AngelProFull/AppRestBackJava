package com.app.api_1.repository;

import com.app.api_1.Entity.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player,Long> {


   // @Query("SELECT p FROM Player p WHERE p.age BETWEEN :minAge AND :maxAge")
    //List<Player> findByAgeInRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);
List<Player> findByAgeBetween(int minAge, int maxAge);
}
