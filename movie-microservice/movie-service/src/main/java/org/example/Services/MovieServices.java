package org.example.Services;

import org.example.Domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieServices {
    Movie create(Movie movie);

    Optional<Movie> findById(int id);

    Optional<Movie> findByTitle(String title);

    Optional<Movie> findByIdOrTitle(int id, String title);

    Movie update(Movie movie);

    void delete(int id);

    List<Movie> findAll();

}
