package org.example.Controller;


import org.example.Domain.Movie;
import org.example.Dto.MovieDto;
import org.example.Exception.MovieAlreadyExistsException;
import org.example.Exception.MovieNotFoundException;
import org.example.Repository.MovieRepository;
import org.example.Services.MovieServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")

public class MovieController {

    @Autowired
    private MovieServices movieServices;

    private Logger logger = LoggerFactory.getLogger(MovieController.class);

    // POST
    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto) {
        logger.info("createMovie: Creating movie with title {}", movieDto.title());
        movieServices.findByIdOrTitle(movieDto.id(), movieDto.title())
                .ifPresent(movie -> {
                    logger.error("createMovie: Movie with id {} or title {} already exists", movieDto.id(), movieDto.title());
                    throw new MovieAlreadyExistsException(
                            String.format("Movie with id %d or title %s already exists", movieDto.id(), movieDto.title()),
                            ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
                    );
                });
        Movie movie = movieServices.create(toEntity(movieDto));
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movie.getId()).toUri()
        ).body(toDto(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable("id") int id) {
        logger.info("getMovie: Fetching movie with id {}", id);
        var optional = movieServices.findById(id);
        if (optional.isEmpty()) {
            logger.error("getMovie: Movie with id {} not found", id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found", id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        return ResponseEntity.ok(toDto(optional.get()));
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        logger.info("getAllMovies: Fetching all movies");
        var list = movieServices.findAll();
        if (list.isEmpty()) {
            logger.error("getAllMovies: No movies found");
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found"),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        return ResponseEntity.ok(list.stream().map(this::toDto).toList());

    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable("id") int id, @RequestBody MovieDto movieDto) {
        logger.info("updateMovie: Updating movie with id {}", id);
        var optional = movieServices.findById(id);
        if (optional.isEmpty()) {
            logger.error("updateMovie: Movie with id {} not found", id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found", id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        Movie movie = optional.get();
        movie.setTitle(movieDto.title());
        movie = movieServices.update(movie);
        return ResponseEntity.ok(toDto(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") int id) {
        logger.info("deleteMovie: Deleting movie with id {}", id);
        var optional = movieServices.findById(id);
        if (optional.isEmpty()) {
            logger.error("deleteMovie: Movie with id {} not found", id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found", id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        movieServices.delete(optional.get().getId());
        return ResponseEntity.noContent().build();
    }

    private Movie toEntity(MovieDto dto) {
        return new Movie(dto.id(), dto.title());
    }

    private MovieDto toDto(Movie entity) {
        return new MovieDto(entity.getId(), entity.getTitle());
    }

}
