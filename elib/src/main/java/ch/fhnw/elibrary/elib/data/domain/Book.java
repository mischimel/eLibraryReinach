package ch.fhnw.elibrary.elib.data.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// Book class author @michimel and @RahelHaeusler

@JsonPropertyOrder({ "isbn", "title", "publishYear", "description", "authorFirstName", "authorLastName", "authorCountry", "genreName" })
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @JsonIgnore //TODO: check if this is needed
    private Long bookID;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column
    private int publishYear;

    @Column
    private String description;

    // @Transient, which means they are not persisted in the database but used for computation purposes
    @Transient
    @Column(nullable = false)
    private String authorFristName;

    @Transient
    @Column(nullable = false)
    private String authorLastName;

    @Transient
    @Column(nullable = false)
    private String authorCountry;

    @Transient
    @Column(nullable = false)
    private String genreName;

    /*@JsonIgnore annotation is specific to the Jackson library and is used for 
    excluding fields from JSON serialization/deserialization, as mentioned earlier. */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "authorID", referencedColumnName = "authorID")
    private Author author;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genreID", referencedColumnName = "genreID")
    private Genre genre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "borrowed", joinColumns = @JoinColumn(name = "bookID"), inverseJoinColumns = @JoinColumn(name = "memberID"))
    private List<Borrowed> borrowedList;


    // constructors
    public Book() {
    }
    
    public Book(Long bookID, String isbn, String title, int publishYear, String description, Author author, Genre genre) {
        this.bookID = bookID;
        this.isbn = isbn;
        this.title = title;
        this.publishYear = publishYear;
        this.description = description;
        this.authorFristName = author.getFirstName();
        this.authorLastName = author.getLastName();
        this.authorCountry = author.getCountry();
        this.genreName = genre.getName();
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


    // Getter and Setter for authorFristName
    public String getAuthorFirstName() {
        if (author != null) {
            return author.getFirstName();
        }
        return authorFristName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFristName = authorFirstName;
    }

    // Getter and Setter for authorLastName
    public String getAuthorLastName() {
        if (author != null) {
            return author.getLastName();
        }
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    // Getter and Setter for authorCountry
    public String getAuthorCountry() {
        if (author != null) {
            return author.getCountry();
        }
        return authorCountry;
    }

    public void setAuthorCountry(String authorCountry) {
        this.authorCountry = authorCountry;
    }

    // Getter and Setter for genreName
    public String getGenreName() {
        if (genre != null) {
            return genre.getName();
        }
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    // Getter and Setter for borrowedList
    @JsonIgnore
    public List<Borrowed> getBorrowedList() {
        return borrowedList;
    }

    @JsonIgnore
    public void setBorrowedList(List<Borrowed> borrowedList) {
        this.borrowedList = borrowedList;
    }

    @JsonIgnore
    public Author getAuthor() {
        return author;
    }

    @JsonIgnore
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonIgnore
    public Genre getGenre() {
        return genre;
    }

    @JsonIgnore
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // toString
    @Override
    public String toString() {
        return "Book [bookID=" + bookID + ", isbn=" + isbn + ", title=" + title + ", publishYear=" + publishYear
        + ", description=" + description + ", authorFristName=" + authorFristName + ", authorLastName=" + authorLastName +
        ", genreName=" + genreName + "]";
}       
    
}
