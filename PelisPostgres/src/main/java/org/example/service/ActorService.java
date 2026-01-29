package org.example.service;

import org.example.model.Actor;
import org.example.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository ac) {
        this.actorRepository = ac;
    }

    //create
    public Actor crearActor(Actor ac) {
        return actorRepository.save(ac);
    }

    //listar todos
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    //listar
    public Optional<Actor> findById(Long id) {
        return actorRepository.findById(id);
    }

    //borrar
    public void deleteById(Long id) {
        actorRepository.deleteById(id);
    }


    //exists
    public boolean existsById(Long id) {
        return actorRepository.existsById(id);
    }

}
