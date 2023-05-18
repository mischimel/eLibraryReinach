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
    private Long book_id;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column
    private int year;

    @Column
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Borrowed> borrowedList = new ArrayList<>();


    // constructors
    public Book(Long book_id, String isbn, String title, int year, String description, Author author, Genre genre) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.description = description;
        this.author = author; // todo: getFirstname() + getLastname()
        this.genre = genre; // todo: getName()
    }

    // getters and setters
    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long id) {
        this.book_id = id;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
        return "Book [id=" + book_id + ", isbn=" + isbn + ", title=" + title + ", year=" + year + ", description=" + description + 
        "author=" + author + ", genre=" + genre + "]";
    }

        


        
    
}
