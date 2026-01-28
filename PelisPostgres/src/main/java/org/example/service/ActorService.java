package org.example.service;

import org.example.model.Actor;
import org.example.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository ac) {
        this.actorRepository = ac;
    }

    //create
    public Actor crearActor(Actor ac) {
        return actorRepository.save(ac);
    }

    //listar todos
    public List<Actor> listarActores() {
        return actorRepository.findAll();
    }

    //listar
    public Optional<Actor> buscarActorPorId(Long id) {
        return actorRepository.findById(id);
    }

    //borrar
    public void borrarActorPorId(Long id) {
        actorRepository.deleteById(id);
    }

}
