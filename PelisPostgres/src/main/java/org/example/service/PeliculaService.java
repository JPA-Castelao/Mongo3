package org.example.service;


import org.example.model.Actor;
import org.example.model.Pelicula;
import org.example.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    private final PeliculaRepository peliculaRepository;


    @Autowired
    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public Pelicula save(Pelicula pelicula) {

        return peliculaRepository.save(pelicula);
    }

    public boolean existe(Long id) {

        return peliculaRepository.existsById(id);
    }

    public void delete(Long id) {
        peliculaRepository.deleteById(id);
    }


    public List<Pelicula> obterPeliculaTitulo(String titulo) {
        return peliculaRepository.findByTitulo(titulo);
    }

    public List<Actor> obterActoresPelicula() {
        return peliculaRepository.obtenerActores();
    }


}
