package ch.fhnw.elibrary.elib.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.fhnw.elibrary.elib.business.service.AuthorService;
import ch.fhnw.elibrary.elib.data.domain.Author;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

// AuthorController class author @michimel

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/newAuthor")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/updateAuthor/{authorID}")
    public Author updateAuthor(@PathVariable Long authorID, @RequestBody Author author) {
        return authorService.updateAuthor(authorID, author);
    }

    /* the following mappings are not used in the application, 
    as budibase provides the functionality to search via the filter function,
    but for completeness we provide the mappings below */
    
    @GetMapping("/findByFirstName/{firstName}")
    public List<Author> getAuthorsByFirstName(@PathVariable String firstName) {
        return authorService.getAuthorsByFirstName(firstName);
    }

    @GetMapping("/findByLastName/{lastName}")
    public List<Author> getAuthorsByLastName(@PathVariable String lastName) {
        return authorService.getAuthorsByLastName(lastName);
    }

    @GetMapping("/findByFirstNameAndLastName/{firstName}/{lastName}")
    public Author getAuthorByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        return authorService.getAuthorByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/findByCountry/{country}")
    public List<Author> getAuthorsByCountry(@PathVariable String country) {
        return authorService.getAuthorsByCountry(country);
    }
}

