package com.app.api_1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "jugador")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String name;
    @Column(name="apellido")
    private String last_name;
    @Column(name="edad ")
    private int age;

    @ManyToOne()
    @JoinColumn(name = "id_equipo",nullable = false) //Nombre de la clave foranea a crear. Siempre tiene que estar la relación.
    @JsonIgnore
    private Team team; //Este nombre team es el atributo que mapea la Entidad Team en la relacion.


}
