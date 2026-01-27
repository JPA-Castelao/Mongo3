package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestActores.MAPPING)
public class RestPeliculas {


    public static String MAPPING = "postgres/RestPeliculas";
}
