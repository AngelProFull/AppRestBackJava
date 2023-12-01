package com.app.api_1.persistence;

import com.app.api_1.Entity.Team;

import java.util.List;
import java.util.Optional;

public interface ITeamDAO {

    Optional<Team> findById(Long id);
    List<Team> findAll();
    void save(Team team);
    void deleteById(Long id);
}
