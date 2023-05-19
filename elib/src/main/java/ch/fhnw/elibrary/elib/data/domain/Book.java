package ch.fhnw.elibrary.elib.data.domain;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

// author @michimel and @RahelHaeusler

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long bookID;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column
    private int publishYear;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "authorID", referencedColumnName = "authorID")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genreID", referencedColumnName = "genreID")
    private Genre genre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "borrowed", joinColumns = @JoinColumn(name = "bookID"), inverseJoinColumns = @JoinColumn(name = "memberID"))
    private List<Borrowed> borrowedList;


    // constructors
    public Book(Long book_id, String isbn, String title, int year, String description, Author author, Genre genre) {
        this.bookID = book_id;
        this.isbn = isbn;
        this.title = title;
        this.publishYear = year;
        this.description = description;
        this.author = author; // todo: getFirstname() + getLastname()
        this.genre = genre; // todo: getName()
    }

    // getters and setters
    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long id) {
        this.bookID = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int year) {
        this.publishYear = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // toString
    @Override
    public String toString() {
        return "Book [id=" + bookID + ", isbn=" + isbn + ", title=" + title + ", year=" + publishYear + ", description=" + description + 
        "author=" + author + ", genre=" + genre + "]";
    }

        


        
    
}
