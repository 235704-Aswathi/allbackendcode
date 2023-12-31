package org.example.Domain;


import javax.persistence.*;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    private int id;

//    @Column(unique = true)
    private String title;

    public Movie() {
    }

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
