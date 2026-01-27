package org.example.service;

import org.example.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ConexionService {
    @Autowired
    private RestTemplate restTemplate;

    private static final String POSTGRES_BASE_URL_PELICULAS = "http://localhost:8081/postgres/peliculas";
    private static final String POSTGRES_BASE_URL_ACTORES = "http://localhost:8081/postgres/actores";

//PELICULAS


    public List<Pelicula> getAllPeliculas() {


        try {
            String url = POSTGRES_BASE_URL_PELICULAS;

            ResponseEntity<List<Pelicula>> respuesta = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Pelicula>>() {
                    }
            );
            return respuesta.getBody() != null ? respuesta.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {

            System.out.println("Erro ao obter as peliculas: " + e.getMessage());

            return Collections.emptyList();
        }


    }


}
