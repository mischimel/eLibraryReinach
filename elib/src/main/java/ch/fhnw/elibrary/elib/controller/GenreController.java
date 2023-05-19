package ch.fhnw.elibrary.elib.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.fhnw.elibrary.elib.business.service.GenreService;
import ch.fhnw.elibrary.elib.data.domain.Genre;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

// author @michimel

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }

    @PutMapping("/{genreId}")
    public Genre updateGenre(@PathVariable Long genreId, @RequestBody Genre genre) {
        return genreService.updateGenre(genreId, genre);
    }

    @GetMapping("/findByName/{name}")
    public List<Genre> getGenresByName(@PathVariable String name) {
        return genreService.getGenresByName(name);
    }
}

