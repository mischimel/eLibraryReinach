package ch.fhnw.elibrary.elib.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.elibrary.elib.data.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    /* custom query methods
    - methods with type Author will only return one author (first one found)
    - methods with type List<Author> will return a list with all authors found 
    author @michimel and @RahelHaeusler*/

    Author findByAuthorID(Long authorID);
    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
    Author findByFirstNameAndLastName(String firstName, String lastName);
    List<Author> findByCountry(String country);
}
