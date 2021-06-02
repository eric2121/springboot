package com.example.entrevueSpringBoot;

import org.springframework.stereotype.Repository;


@Repository
public class FilmDAO {

    private static Films list = new Films();

     Films getAllFilms() {
        return list;
    }

    public Film getFilmById(long id) {
        return list.getFilmById(id);
    }

    public void addFilm(Film film) {
        list.getFilmList().put(film.getId(), film);

    }
}
