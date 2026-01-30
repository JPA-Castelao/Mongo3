package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Actor {


    private Long idActor;
    private String nome;
    private String apellidos;
    private String nacionalidade;
    @JsonProperty("idpelicula")
    private Pelicula idpelicula;

    public Actor() {
    }

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apellidos;
    }

    public void setApelidos(String apelidos) {
        this.apellidos = apelidos;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Pelicula getId_pelicula() {
        return idpelicula;
    }

    public void setId_pelicula(Pelicula id_pelicula) {
        this.idpelicula = id_pelicula;
    }
}
