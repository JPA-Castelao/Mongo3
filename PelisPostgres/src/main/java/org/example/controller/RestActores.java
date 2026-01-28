package org.example.controller;

import org.example.model.Actor;
import org.example.model.Pelicula;
import org.example.service.ActorService;
import org.example.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestActores.MAPPING)
public class RestActores {


    public static final String MAPPING = "postgres/actores";
    @Autowired
    private ActorService actorService;
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Actor> getAll() {
        return actorService.listarActores();
    }

    @GetMapping("/{id}")

    public ResponseEntity<Actor> getById(@PathVariable Long id) {

        return actorService.buscarActorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


    @PostMapping
    public ResponseEntity<Actor> create(@RequestBody Actor actor) {
        if (actor.getId_pelicula() != null) {
            Pelicula pid = peliculaService.findById(actor.getId_pelicula().getIdPelicula())
                    .orElse(null);
            if (pid == null) {
                return ResponseEntity.badRequest().build();
            }
            actor.setId_pelicula(pid);
        }

        Actor guardado = actorService.crearActor(actor);
        return ResponseEntity.ok(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> update(@PathVariable Long id, @RequestBody Actor actor) {


        return actorService.buscarActorPorId(id)
                .map(x -> {


                }).orElse(ResponseEntity.notFound().build());


    }
}
