package org.example.Repository;

import org.example.Domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Book,Integer> {
    Optional<List<Book>> findByLanguage(String language);

}
