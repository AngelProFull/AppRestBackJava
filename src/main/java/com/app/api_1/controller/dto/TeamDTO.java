package com.app.api_1.controller.dto;

import com.app.api_1.Entity.Player;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TeamDTO {
    private Long id;

    private String name;


    private List<Player> playerList = new ArrayList<>();
}
