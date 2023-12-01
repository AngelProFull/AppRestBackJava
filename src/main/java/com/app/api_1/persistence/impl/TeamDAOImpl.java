package com.app.api_1.persistence.impl;

import com.app.api_1.Entity.Team;
import com.app.api_1.persistence.ITeamDAO;

import com.app.api_1.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeamDAOImpl implements ITeamDAO {

    //Inyectamos el repositorio.
    @Autowired
    private TeamRepository teamRepository;


    @Override
    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public List<Team> findAll() {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }
}
