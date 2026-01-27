package org.example.repository;

import org.example.model.Actor;
import org.example.model.Pelicula;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository {

    List<Actor> findByNomeCompleto(String nome,String apelidos);

}
