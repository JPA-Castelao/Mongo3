package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.model.Actor;
import org.example.model.Pelicula;
import org.example.repository.ActorRepository;
import org.example.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;
    private final ActorRepository actoresRepository;
    private final ObjectMapper objectMapper; // Inyectamos el ObjectMapper de Spring

    public PeliculaService(PeliculaRepository peliculaRepository, ActorRepository actoresRepository, ObjectMapper objectMapper) {
        this.peliculaRepository = peliculaRepository;
        this.actoresRepository = actoresRepository;
        this.objectMapper = objectMapper;
    }

    public void crearPelicula(Pelicula peliculas) {
        peliculaRepository.save(peliculas);
    }

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    public List<Pelicula> buscarPeliculaTitulo(String titulo) {
        return peliculaRepository.findByTitulo(titulo);
    }

    public Optional<Actor> listarPeliculasPorActor(long idActor) {
        return actoresRepository.findById(String.valueOf(idActor));
    }

    public Optional<Pelicula> listarPeliculaPorId(long idPelicula) {
        return peliculaRepository.findById(String.valueOf(idPelicula));
    }

    public  void exportarJson() {
        List<Pelicula> peliculas = listarPeliculas();

        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            File archivo = new File("E:\\DAM\\ad\\Mongo3\\MongoChamador\\src\\main\\json.json");

            objectMapper.writeValue(archivo, peliculas);

        } catch (Exception e) {
            System.err.println("Error al exportar JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

