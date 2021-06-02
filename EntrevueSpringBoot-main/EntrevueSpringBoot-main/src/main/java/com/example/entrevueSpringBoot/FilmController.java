package com.example.entrevueSpringBoot;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class FilmController {
    @Autowired
    private FilmDAO filmDAO;

    @GetMapping("/api/film/{id}")
    Film un (@PathVariable Long id) {
        return (filmDAO.getFilmById(id));
    }

    @PostMapping(
        path = "/api/film",
        consumes = "application/json",
        produces = "application/json")

    public ResponseEntity<Object> addEmployee(
        @RequestBody Film film)
    {
        filmDAO.addFilm(film);

        URI location
            = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(
                film.getId())
            .toUri();

        return ResponseEntity
            .created(location)
            .build();
    }
}
