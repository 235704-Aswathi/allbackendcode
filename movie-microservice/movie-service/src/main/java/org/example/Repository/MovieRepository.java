package org.example.Repository;

import org.example.Domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Optional<Movie> findByTitle(String title);

    Optional<Movie> findByIdOrTitle(int id, String title);
}
