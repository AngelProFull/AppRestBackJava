package com.app.api_1.persistence;

import com.app.api_1.Entity.Player;

import java.util.List;
import java.util.Optional;

public interface IPlayerDAO {

    Optional<Player> findById(Long id);
    List<Player> findAll();

    List<Player> findByAgeInRange(int minAge, int maxAge);
    void save(Player player);
    void deleteById(Long id);


}
