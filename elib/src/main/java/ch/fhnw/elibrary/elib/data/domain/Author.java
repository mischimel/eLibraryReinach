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
    private Long authorID;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    // constructor
    public Author() {  
    }

    public Author(Long authorID, String firstName, String lastName, String country) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    // getters and setters
    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long id) {
        this.authorID = id;
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
        return "Author [id=" + authorID + ", firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + "]";
    }
}
