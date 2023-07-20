package org.example.Services;

import org.example.Dto.MovieDto;

import java.util.Optional;

public interface MovieService {

    Optional<MovieDto> findById(int id);
}

