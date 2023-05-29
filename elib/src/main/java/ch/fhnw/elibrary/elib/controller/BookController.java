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

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/newBook")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/updateBook/{bookID}")
    public Book updateBook(@PathVariable Long bookID, @RequestBody Book book) {
        return bookService.updateBook(bookID, book);
    }

    /* the following mappings are not used in the application, 
    as budibase provides the functionality to search via the filter function,
    but for completeness we provide the mappings below */
    
    @GetMapping("/findByTitle/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title) {
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
