package org.example.Controller;

import org.example.Domain.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class AuthorController {
    private List<Author>authors=List.of(new Author("abc@123", "John","fiction"),
                                         new Author("ac@12","James","fiction"));

    @GetMapping
    public List<Author> getAuthors(){
        return authors;
    }
    @PostMapping
    public Author create(Author author){
        authors.add(author);
        return author;
    }


}
