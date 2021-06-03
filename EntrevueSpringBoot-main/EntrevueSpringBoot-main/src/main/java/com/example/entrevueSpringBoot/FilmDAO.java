package com.example.entrevueSpringBoot;

import org.springframework.stereotype.Repository;


@Repository
public class FilmDAO {

    private static Films list = new Films();
    private static Long nextFreeId = (long)1;

    public Long getNextFreeId() {
        return nextFreeId;
    }

    public void setNextFreeId(Long nextFreeId) {
        FilmDAO.nextFreeId = nextFreeId;
    }

     public Films getAllFilms() {
        return list;
    }

    public Film getFilmById(long id) {
        return list.getFilmById(id);
    }

    public void addFilm(Film film) {
        list.getFilmList().put(film.getId(), film);

    }
}
