package ch.fhnw.elibrary.elib.data.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long genre_id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    // constructor
    public Genre(Long genre_id, String name) {
        this.genre_id = genre_id;
        this.name = name;
    }

    // getters and setters
    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long id) {
        this.genre_id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString
    @Override
    public String toString() {
        return String.format("Genre[id=" + genre_id + ", name=" + name + "]");
    }
    
}
