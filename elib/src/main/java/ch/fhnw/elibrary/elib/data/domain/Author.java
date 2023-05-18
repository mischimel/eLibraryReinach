package ch.fhnw.elibrary.elib.data.domain;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

// author @michimel and @RahelHaeusler


@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long author_id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    // constructor
    public Author(Long author_id, String firstName, String lastName, String country) {
        this.author_id = author_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    // getters and setters
    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long id) {
        this.author_id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // toString
    @Override
    public String toString() {
        return "Author [id=" + author_id + ", firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + "]";
    }
}
