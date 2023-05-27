package ch.fhnw.elibrary.elib.business.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ch.fhnw.elibrary.elib.data.domain.Genre;
import ch.fhnw.elibrary.elib.data.repository.GenreRepository;

// GenreService class author @michimel

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Long genreId, Genre genreDetails) {
        Genre genre = getGenreById(genreId);
        genre.setName(genreDetails.getName());
        return genreRepository.save(genre);
    }

    /* the following methods are not used in the application, 
    as budibase provides the functionality to search via the filter function,
    but for completeness we provide the methods below */
    
    public List<Genre> getGenresByName(String name) {
        return genreRepository.findByName(name);
    }

    private Genre getGenreById(Long genreId) {
        return genreRepository.findByGenreID(genreId);
    }
}

