package org.example.Controller;


import org.example.Domain.Book;
import org.example.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class controller {

    @Autowired
    private BookService service;

    @GetMapping()
    public ResponseEntity<List<Book>> getAll() {
        List<Book> book = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
    @PostMapping("/bookdet")
    public ResponseEntity<Book> create(@RequestBody Book book){
         if(book==null){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         }
         Book book1=service.saveBook(book);
         return  ResponseEntity.status(HttpStatus.OK).body(book1);

    }
    @GetMapping("/{language}")
        public ResponseEntity<Optional<List<Book>>> getByLanguage(@PathVariable String language){
            Optional<List<Book>> booklist= service.findByLanguage(language);
            if(booklist==null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            else {
                return ResponseEntity.status(HttpStatus.CREATED).body(booklist);
            }
        }
    }

