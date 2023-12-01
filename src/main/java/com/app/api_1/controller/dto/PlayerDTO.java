package com.app.api_1.controller.dto;

import com.app.api_1.Entity.Team;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDTO {

    private Long id;

    private String name;

    private String last_name;

    private int age;


    private Team team; //Este nombre team es el atributo que mapea la Entidad Team en la relacion.




}
