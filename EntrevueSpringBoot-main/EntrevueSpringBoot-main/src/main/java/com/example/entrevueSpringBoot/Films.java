package com.example.entrevueSpringBoot;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Films {
    private Map<Long, Film> movieList = new LinkedHashMap<>();

    public Map<Long, Film> getFilmList() {
        if (movieList == null) {
            movieList
                = new HashMap<>();
        }
        return movieList;
    }

    public Film getFilmById(long id) {
        if (movieList == null) {
            movieList
                = new HashMap<>();
        }
        return movieList.get(id);
    }
}
