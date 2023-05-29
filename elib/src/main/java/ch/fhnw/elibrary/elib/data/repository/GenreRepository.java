package ch.fhnw.elibrary.elib.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.elibrary.elib.data.domain.Genre;

// GenreRepository class author @michimel and @RahelHaeusler

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    /*custom query methods
    - methods with type Book will only return one book (first one found)
    - methods with type List<Book> will return a list with all books found
    author @michimel and @RahelHaeusler*/

    Genre findByGenreID(Long genreID);
    Genre findByName(String name);
  
    
}
