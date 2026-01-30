package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
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


    public static final String MAPPING = "probas/actores";
    @Autowired
    private ActorService actorService;
    @Autowired
    private PeliculaService peliculaService;
    @Operation(summary = "Listar")

    @GetMapping
    public List<Actor> getAll() {
        return actorService.findAll();
    }
    @Operation(summary = "Buscar por Id")

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getById(@PathVariable Long id) {
        return actorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear")

    @PostMapping
    public ResponseEntity<Actor> create(@RequestBody Actor actor) {
        if (actor.getPelicula() != null) {
            Pelicula pid = peliculaService.findById(actor.getPelicula().getIdPelicula())
                    .orElse(null);
            if (pid == null) {
                return ResponseEntity.badRequest().build();
            }
            actor.setPelicula(pid);
        }

        Actor guardado = actorService.crearActor(actor);
        return ResponseEntity.ok(guardado);
    }
    @Operation(summary = "Actualizar")
    @PutMapping("/{id}")
    public ResponseEntity<Actor> update(@PathVariable Long id, @RequestBody Actor actor) {

        return actorService.findById(id)
                .map(x -> {
                    x.setNome(actor.getNome());
                    x.setApelidos(actor.getApelidos());
                    x.setNacionalidade(actor.getNacionalidade());
                    if (actor.getPelicula() != null) {
                        x.setPelicula(actor.getPelicula());
                    }
                    return ResponseEntity.ok(actorService.crearActor(x));
                }).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Borrar")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!actorService.existsById(id)) {
            return ResponseEntity.notFound().build();

        }
        actorService.deleteById(id);
        return ResponseEntity.noContent().build();


    }

}
