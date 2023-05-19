package ch.fhnw.elibrary.elib.business.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ch.fhnw.elibrary.elib.data.domain.Book;
import ch.fhnw.elibrary.elib.data.repository.BookRepository;

// author @michimel

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long bookID, Book bookDetails) {
        Book book = getBookById(bookID);
        book.setTitle(bookDetails.getTitle());
        book.setIsbn(bookDetails.getIsbn());
        book.setPublishYear(bookDetails.getPublishYear());
        book.setDescription(bookDetails.getDescription());
        book.setAuthor(bookDetails.getAuthor());
        book.setGenre(bookDetails.getGenre());
        return bookRepository.save(book);
    }

    public List<Book> getBooksByTitle(String title) {
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

    private Book getBookById(Long bookID) {
        return bookRepository.findByBookID(bookID);
    }
}
