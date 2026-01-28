package org.example.controller;

import org.example.model.Actor;
import org.example.service.ActorService;
import org.example.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Actor> getAll(){
        return equipoService
    }

}
