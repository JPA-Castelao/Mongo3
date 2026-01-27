package org.example.model;

public class Actor {


    Long idActor;
    String nome;
    String apelidos;
    String nacionalidade;
    Pelicula id_pelicula;


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
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Pelicula getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Pelicula id_pelicula) {
        this.id_pelicula = id_pelicula;
    }
}
