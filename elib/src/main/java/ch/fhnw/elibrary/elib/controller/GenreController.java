package ch.fhnw.elibrary.elib.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ch.fhnw.elibrary.elib.business.service.GenreService;
import ch.fhnw.elibrary.elib.data.domain.Genre;


// GenreController class author @michimel

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @PostMapping(path = "/newGenre", consumes = "application/json", produces = "application/json")
    public ResponseEntity createGenre(@RequestBody Genre genre) {
        try {
            genre = genreService.createGenre(genre);

        } 
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());

        }
        return ResponseEntity.ok(genre);
    }

    // to update an existing genre, after finding the genre by ID, the genre is updated with the new values
    @PutMapping(path = "/updateGenre/{genreID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateGenre(@PathVariable Long genreID, @RequestBody Genre genreDetails) {
        try {
            Genre genre = genreService.updateGenre(genreID, genreDetails);
            return ResponseEntity.ok(genre);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
  

    /* the following mappings are not used in the application, 
    as budibase provides the functionality to search via the filter function,
    but for completeness we provide the mappings below */
    
    @GetMapping("/findByName/{name}")
    public Genre getGenresByName(@PathVariable String name) {
        return genreService.getGenresByName(name);
    }
}

