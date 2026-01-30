package org.example.service;

import org.example.model.Actor;
import org.example.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ConexionService {
    @Autowired
    private RestTemplate restTemplate;
    private static final String POSTGRES_BASE_URL_PELICULAS = "http://localhost:8085/probas/peliculas";
    private static final String POSTGRES_BASE_URL_ACTORES = "http://localhost:8085/probas/actores";


    public List<Pelicula> getAllPeliculas() {
        try {
            String url = POSTGRES_BASE_URL_PELICULAS;
            ResponseEntity<List<Pelicula>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Pelicula>>() {
                    }
            );
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao obter peliculas: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Pelicula getPeliculaById(String id) {
        try {
            String url = POSTGRES_BASE_URL_PELICULAS + "/" + id;
            ResponseEntity<Pelicula> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, Pelicula.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao obter pelicula: " + e.getMessage());
            return null;
        }
    }

    public Pelicula getPeliculaByTitulo(String titulo) {
        try {
            String url = POSTGRES_BASE_URL_PELICULAS + "/titulo/" + titulo;
            ResponseEntity<Pelicula> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, Pelicula.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao obter pelicula: " + e.getMessage());
            return null;
        }
    }

    public Pelicula createPelicula(Pelicula pelicula) {
        try {
            String url = POSTGRES_BASE_URL_PELICULAS;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Pelicula> request = new HttpEntity<>(pelicula, headers);

            ResponseEntity<Pelicula> response = restTemplate.exchange(
                    url, HttpMethod.POST, request, Pelicula.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao crear a película: " + e.getMessage());
            return null;
        }
    }

    public Pelicula updatePelicula(Long id, Pelicula datos) {
        try {
            String url = POSTGRES_BASE_URL_PELICULAS + "/" + id;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Pelicula> request = new HttpEntity<>(datos, headers);

            ResponseEntity<Pelicula> response = restTemplate.exchange(
                    url, HttpMethod.PUT, request, Pelicula.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao actualizar pelicula " + id + ": " + e.getMessage());
            return null;
        }
    }

    public boolean deletePelicula(Long id) {
        try {
            String url = POSTGRES_BASE_URL_PELICULAS + "/" + id;
            restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
            return true;
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao borrar o pelicula " + id + ": " + e.getMessage());
            return false;
        }
    }

    public List<Actor> getAllActor() {
        try {
            String url = POSTGRES_BASE_URL_ACTORES;
            ResponseEntity<List<Actor>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Actor>>() {
                    }
            );
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao obter actores: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Actor getActorById(Long id) {
        try {
            String url = POSTGRES_BASE_URL_ACTORES + "/" + id;
            ResponseEntity<Actor> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, Actor.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao obter actor " + id + ": " + e.getMessage());
            return null;
        }
    }

    public Actor createActor(Actor actor) {
        try {
            String url = POSTGRES_BASE_URL_ACTORES;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Actor> request = new HttpEntity<>(actor, headers);
            ResponseEntity<Actor> response = restTemplate.exchange(
                    url, HttpMethod.POST, request, Actor.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao crear actor: " + e.getMessage());
            return null;
        }
    }

    public Actor updateActor(Long id, Actor datos) {
        try {
            String url = POSTGRES_BASE_URL_ACTORES + "/" + id;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Actor> request = new HttpEntity<>(datos, headers);
            ResponseEntity<Actor> response = restTemplate.exchange(
                    url, HttpMethod.PUT, request, Actor.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao actualizar actor " + id + ": " + e.getMessage());
            return null;
        }
    }

    public boolean deleteActor(Long id) {
        try {
            String url = POSTGRES_BASE_URL_ACTORES + "/" + id;
            restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
            return true;
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao borrar actor " + id + ": " + e.getMessage());
            return false;
        }
    }

}
