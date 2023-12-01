package com.app.api_1.persistence.impl;

import com.app.api_1.Entity.Player;
import com.app.api_1.persistence.IPlayerDAO;
import com.app.api_1.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PlayerDAOImpl implements IPlayerDAO {

    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> findAll() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public List<Player> findByAgeInRange(int minAge, int maxAge) {
        return playerRepository.findByAgeBetween(minAge,maxAge);
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
