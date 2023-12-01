package com.app.api_1.service.impl;

import com.app.api_1.Entity.Team;
import com.app.api_1.persistence.ITeamDAO;
import com.app.api_1.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements ITeamService {

    @Autowired
    private ITeamDAO teamDAO;

    @Override
    public Optional<Team> findById(Long id) {
        return teamDAO.findById(id);
    }

    @Override
    public List<Team> findAll() {
        return teamDAO.findAll();
    }

    @Override
    public void save(Team team) {
        teamDAO.save(team);
    }

    @Override
    public void deleteById(Long id) {
        teamDAO.deleteById(id);
    }
}
