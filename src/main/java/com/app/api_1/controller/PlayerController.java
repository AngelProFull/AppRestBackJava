package com.app.api_1.controller;

import com.app.api_1.Entity.Player;
import com.app.api_1.controller.dto.PlayerDTO;

import com.app.api_1.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> playerfindById(@PathVariable Long id) {

        //Obtenemos el producto.
        Optional<Player> playerOptional = playerService.findById(id);
        //Validamos si está presente.
        if(playerOptional.isPresent()) {
            //Recupero el producto
            Player player = playerOptional.get();
            PlayerDTO playerDTO = PlayerDTO.builder()
                    .id(player.getId())
                    .name(player.getName())
                    .last_name(player.getLast_name())
                    .age(player.getAge())
                    .team(player.getTeam())
                    .build();
            return ResponseEntity.ok(playerDTO);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        //Retornamos un List
        List<PlayerDTO> playerDTOList = playerService.findAll()
                .stream()
                .map(player -> PlayerDTO.builder()
                        .id(player.getId())
                        .name(player.getName())
                        .last_name(player.getLast_name())
                        .age(player.getAge())
                        .team(player.getTeam())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(playerDTOList);
    }




        @PostMapping("/save")
        public ResponseEntity<?> save(@RequestBody PlayerDTO playerDTO) throws URISyntaxException {

            if (playerDTO.getName() == null || playerDTO.getName().isBlank()) {
                return ResponseEntity.badRequest().body("El nombre del jugador es obligatorio.");
            }

            if (playerDTO.getAge() <= 0) {
                return ResponseEntity.badRequest().body("La edad del jugador debe ser un número positivo.");
            }

            if (playerDTO.getTeam() == null) {
                return ResponseEntity.badRequest().body("El equipo del jugador es obligatorio.");
            }


            // Puedes agregar más validaciones según sea necesario...

            // Construir el objeto Player
            Player player = Player.builder()
                    .name(playerDTO.getName())
                    .last_name(playerDTO.getLast_name())
                    .age(playerDTO.getAge())
                    .team(playerDTO.getTeam())  // Asumiendo que team es un objeto Team
                    .build();

            // Guardar el jugador
            playerService.save(player);

            return ResponseEntity.created(new URI("/api/player/save")).build();
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {

            Optional<Player> playerOptional = playerService.findById(id);

            if (playerOptional.isPresent()) {
                //Si existe recuperamos
                Player player = playerOptional.get();
                player.setName(playerDTO.getName());
                player.setLast_name(playerDTO.getLast_name());
                player.setAge(playerDTO.getAge());
                player.setTeam(playerDTO.getTeam());

                //Guardamos los cambios.
                playerService.save(player);

            }
            return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {

        if(id != null) {
            return ResponseEntity.ok("Registro eliminado");
        }
            return ResponseEntity.badRequest().build();
        }

        @GetMapping("/findByAgeInRange")
        public ResponseEntity<?> findByAgeInRange(@RequestParam int minAge, @RequestParam int maxAge) {

            List<Player> players = playerService.findByAgeInRange(minAge, maxAge);

            if(players.size() >= 1) {
                return ResponseEntity.ok(players);
            }
           return ResponseEntity.badRequest().build();

        }

    }





