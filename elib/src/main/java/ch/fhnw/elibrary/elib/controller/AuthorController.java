package ch.fhnw.elibrary.elib.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import ch.fhnw.elibrary.elib.business.service.AuthorService;
import ch.fhnw.elibrary.elib.data.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;

// AuthorController class author @michimel

@RestController
@RequestMapping(path = "/api/author")
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // @PostMapping("/newAuthor")
    // public Author createAuthor(@RequestBody Author author) {
    //     return authorService.createAuthor(author);
    // }


    @PostMapping(path = "/newAuthor", consumes = "application/json", produces = "application/json")
    public ResponseEntity createAuthor(@RequestBody Author author) {
        try {
            author = authorService.createAuthor(author);

        } 
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());

        }
        return ResponseEntity.ok(author);
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

