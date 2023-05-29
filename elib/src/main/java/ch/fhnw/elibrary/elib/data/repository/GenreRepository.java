package ch.fhnw.elibrary.elib.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.elibrary.elib.data.domain.Genre;

// GenreRepository class author @michimel and @RahelHaeusler

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findByGenreID(Long genreID);
    Genre findByName(String name);
  
    
}
