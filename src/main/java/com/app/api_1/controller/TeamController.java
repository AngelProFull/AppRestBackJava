package com.app.api_1.controller;

import com.app.api_1.Entity.Team;
import com.app.api_1.controller.dto.TeamDTO;
import com.app.api_1.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/team")
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Team> teamOptional = teamService.findById(id);

        if(teamOptional.isPresent()) {
            Team team = teamOptional.get(); //Obtenemos  la Entity completa

//Por buenas prácticas construimos nuestro DTO para retornarlo.
            //Extraemos los datos de Entity y lo seteamos en el DTO.

            TeamDTO teamDTO = TeamDTO.builder()
                    .id(team.getId())
                    .name(team.getName())
                    .playerList(team.getPlayerList())
                    .build();

            return ResponseEntity.ok(teamDTO);

        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        //teamService.findAll() devuelve un Entity, pero yo quiero que retorne un Dto.

        List<TeamDTO> teamList = teamService.findAll()
                .stream()
                .map(team -> TeamDTO.builder()
                        .id(team.getId())
                        .name(team.getName())
                        .playerList(team.getPlayerList())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(teamList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TeamDTO teamDTO) throws URISyntaxException {
        if(teamDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        teamService.save(Team.builder()
                .name(teamDTO.getName())
                .build());
        return ResponseEntity.created(new URI("/api/team/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Long id, @RequestBody TeamDTO teamDTO) {

        //Validamos si el Team ya existe.

        Optional<Team> teamOptional = teamService.findById(id);

        if(teamOptional.isPresent()) {
            //Recuperamos el Entity Team, el objeto
            Team team = teamOptional.get();
            //Le cambiamos el nombre
            team.setName(teamDTO.getName());
            //Lo guardamos.
            teamService.save(team);

            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if(id != null){
            teamService.deleteById(id);
            return ResponseEntity.ok("Equipo eliminado");
        }
        return ResponseEntity.badRequest().build();

    }


}
