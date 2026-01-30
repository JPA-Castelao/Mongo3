package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Pelicula;
import org.example.service.ActorService;
import org.example.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPeliculas.MAPPING)
public class RestPeliculas {

    public static final String MAPPING = "probas/peliculas";

    @Autowired
    private ActorService as;
    @Autowired
    private PeliculaService ps;

    @Operation(summary = "Listar")
    @GetMapping
    public List<Pelicula> getAll() {

        return ps.obterToasPeliculas();
    }

    @Operation(summary = "Buscar por id")
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getById(@PathVariable Long id) {

        return ps.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "Buscar por título")
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Pelicula> getByTitulo(@PathVariable String titulo) {
        return ps.obterPeliculaTitulo(titulo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(summary = "Crear")
    @PostMapping
    public ResponseEntity<Pelicula> create(@RequestBody Pelicula pelicula) {

        Pelicula peliNueva = ps.save(pelicula);
        return ResponseEntity.ok(peliNueva);

    }

    @Operation(summary = "Update")
    @PutMapping()
    public ResponseEntity<Pelicula> update(@PathVariable Long id, @RequestBody Pelicula pelicula) {

        return ps.findById(id).map(x -> {
            x.setTitulo(pelicula.getTitulo());
            x.setAno(pelicula.getAno());
            x.setXenero(pelicula.getXenero());
            return ResponseEntity.ok(ps.save(x));
        }).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Borrar")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!ps.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        ps.delete(id);
        return ResponseEntity.noContent().build();
    }
}