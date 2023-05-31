package ch.fhnw.elibrary.elib.business.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ch.fhnw.elibrary.elib.data.domain.Author;
import ch.fhnw.elibrary.elib.data.domain.Book;
import ch.fhnw.elibrary.elib.data.domain.Genre;
import ch.fhnw.elibrary.elib.data.repository.AuthorRepository;
import ch.fhnw.elibrary.elib.data.repository.BookRepository;
import ch.fhnw.elibrary.elib.data.repository.GenreRepository;

// BookService class author @michimel

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
            GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    // checks if the book with the given isbn already exists, if not, the book is
    // saved
    // and checks if the author already exists, if not, the author is saved and the
    // author is assigned to the book
    // and checks if the genre already exists, if not, the genre is saved and the
    // genre is assigned to the book

    public Book createBook(Book book) throws Exception {
        if (book.getIsbn() != null) {
            if (bookRepository.findByIsbn(book.getIsbn()) == null) {
                if (book.getAuthorFirstName() != null && book.getAuthorLastName() != null
                        && book.getAuthorCountry() != null) {
                    if (authorRepository.findByFirstNameAndLastName(book.getAuthorFirstName(),
                            book.getAuthorLastName()) == null) {
                        Author author = new Author();
                        author.setFirstName(book.getAuthorFirstName());
                        author.setLastName(book.getAuthorLastName());
                        author.setCountry(book.getAuthorCountry());
                        authorRepository.save(author);
                        book.setAuthor(author);
                    } else {
                        Author author = authorRepository.findByFirstNameAndLastName(book.getAuthorFirstName(),
                                book.getAuthorLastName());
                        book.setAuthor(author);
                    }

                }

                if (book.getGenreName() != null) {
                    if (genreRepository.findByName(book.getGenreName()) == null) {
                        Genre genre = new Genre();
                        genre.setName(book.getGenreName());
                        genreRepository.save(genre);
                        book.setGenre(genre);
                    } else {
                        Genre genre = genreRepository.findByName(book.getGenreName());
                        book.setGenre(genre);
                    }
                }
                return bookRepository.save(book);
            } else
                throw new Exception("Book with ISBN " + book.getIsbn() + " already exists");

        }
        throw new Exception("Invalid ISBN");
    }

    // to update an existing book, after finding the book by ID, the book is updated
    // with the new values
    public Book updateBook(Long bookID, Book bookDetails) {
        Book book = bookRepository.findByBookID(bookID);
        if (book == null) {
            throw new RuntimeException("Book not found for this ID :: " + bookID);
        }
        book.setTitle(bookDetails.getTitle());
        book.setIsbn(bookDetails.getIsbn());
        book.setPublishYear(bookDetails.getPublishYear());
        book.setDescription(bookDetails.getDescription());
        book.setAuthorFirstName(bookDetails.getAuthorFirstName());
        book.setAuthorLastName(bookDetails.getAuthorLastName());
        book.setAuthorCountry(bookDetails.getAuthorCountry());
        book.setGenreName(bookDetails.getGenreName());
        return bookRepository.save(book);
    }

    /*
     * the following methods are not used in the application,
     * as budibase provides the functionality to search via the filter function,
     * but for completeness we provide the methods below
     */

    public Book getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public List<Book> getBooksByPublishYear(int publishYear) {
        return bookRepository.findByPublishYear(publishYear);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    /* never used locally
    private Book getBookById(Long bookID) {
        return bookRepository.findByBookID(bookID);
    }
    */
}
