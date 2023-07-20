package org.example.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="authors")
public class Author {


    @Column(name="email")
    private String email;

    @Column(name="fullname")
    private String FullName;

    @Column(name="genre")
    private String genre;

    public Author(){

    }

    public Author(String email, String fullName, String genre) {
        this.email = email;
        FullName = fullName;
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return FullName;
    }

    public String getGenre() {
        return genre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
