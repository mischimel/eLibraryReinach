package ch.fhnw.elibrary.elib.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ch.fhnw.elibrary.elib.business.service.BookService;
import ch.fhnw.elibrary.elib.data.domain.Book;

// BookController class author @michimel

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(path = "/newBook", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            book = bookService.createBook(book);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());

        }
        return ResponseEntity.ok(book);
    }

    // to update an existing book, after finding the book by ID, the book is updated
    // with the new values
    @PutMapping(path = "/updateBook/{bookID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookID, @RequestBody Book bookDeatils) {
        try {
            Book book = bookService.updateBook(bookID, bookDeatils);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /*
     * the following mappings are not used in the application,
     * as budibase provides the functionality to search via the filter function,
     * but for completeness we provide the mappings below
     */

    @GetMapping("/findByTitle/{title}")
    public Book getBooksByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/findByIsbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @GetMapping("/findByPublishYear/{publishYear}")
    public List<Book> getBooksByPublishYear(@PathVariable int publishYear) {
        return bookService.getBooksByPublishYear(publishYear);
    }

    @GetMapping("/findByAuthor/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/findByGenre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }
}
