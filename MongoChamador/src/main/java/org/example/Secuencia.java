package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Pelicula;
import org.example.service.ConexionService;
import org.example.service.PeliculaService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class Secuencia {

    private final ObjectMapper mapper;
    private final PeliculaService peliculaService;
    private final ConexionService conexionService;

    public Secuencia(PeliculaService peliculaService, ConexionService conexionService) {
        this.peliculaService = peliculaService;
        this.mapper = new ObjectMapper();
        this.conexionService = conexionService;
    }

    public void executar() {

        try {
            List<Pelicula> peliculaJson = mapper.readValue(new File("E:\\DAM\\ad\\Mongo3\\MongoChamador\\src\\main\\json.json"),
                    new TypeReference<List<Pelicula>>() {
                    });

            for (Pelicula p : peliculaJson) {
                peliculaService.crearPelicula(p);

                conexionService.createPelicula(p);
            }

            System.out.println("Enviando película: " + peliculaJson.toString());

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        peliculaService.crearPelicula(conexionService.getPeliculaById("10"));

        peliculaService.crearPelicula(conexionService.getPeliculaByTitulo("Harakiri"));

        peliculaService.exportarJson();

    }
}
