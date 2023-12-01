package com.app.api_1.service;

import com.app.api_1.Entity.Team;

import java.util.List;
import java.util.Optional;

public interface ITeamService {

    Optional<Team> findById(Long id);
    List<Team> findAll();
    void save(Team team);
    void deleteById(Long id);
}
