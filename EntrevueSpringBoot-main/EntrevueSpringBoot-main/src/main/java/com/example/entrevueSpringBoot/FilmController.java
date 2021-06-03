package com.example.entrevueSpringBoot;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/api/film")
public class FilmController {
    @Autowired
    private FilmDAO filmDAO;

    @GetMapping("/{id}")
    Film un (@PathVariable Long id) {
        return (filmDAO.getFilmById(id));
    }

    @GetMapping(path = "",produces = "application/json")
    public Films getAllFilms(){
        return filmDAO.getAllFilms();
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Film film)
    {
        setFilmIds(film);
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

    private void setFilmIds(Film film){
        long nextFreeId = filmDAO.getNextFreeId();
        film.setId(nextFreeId);
        nextFreeId++;

        for (Acteur acteur : film.getActeurs())  {
            acteur.setId(nextFreeId);
            nextFreeId++;
        }
        filmDAO.setNextFreeId(nextFreeId);
    }
}
