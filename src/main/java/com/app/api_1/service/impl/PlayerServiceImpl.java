package com.app.api_1.service.impl;

import com.app.api_1.Entity.Player;
import com.app.api_1.persistence.IPlayerDAO;
import com.app.api_1.persistence.ITeamDAO;
import com.app.api_1.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private IPlayerDAO playerDAO;

    @Override
    public Optional<Player> findById(Long id) {
        return playerDAO.findById(id);
    }

    @Override
    public List<Player> findAll() {
        return playerDAO.findAll();
    }

    @Override
    public List<Player> findByAgeInRange(int minAge, int maxAge) {
        return playerDAO.findByAgeInRange(minAge,maxAge);
    }

    @Override
    public void save(Player player) {
        playerDAO.save(player);
    }

    @Override
    public void deleteById(Long id) {
        playerDAO.deleteById(id);
    }
}
