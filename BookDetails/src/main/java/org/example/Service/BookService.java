package org.example.Service;


import org.example.Domain.Book;
import org.example.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService  {

   @Autowired
    private Repository repository;

   public List<Book> getAll(){
       return repository.findAll();
   }

   public Optional<List<Book>> findByLanguage(String language){
       return repository.findByLanguage(language);
   }
   public Book saveBook(Book book){
      return repository.save(book);
   }

}
