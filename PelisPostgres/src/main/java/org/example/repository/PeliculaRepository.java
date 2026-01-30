package org.example.repository;


import org.example.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {


    Optional<Pelicula> findByTitulo(String titulo);

}
