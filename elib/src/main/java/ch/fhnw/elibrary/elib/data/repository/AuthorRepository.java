package ch.fhnw.elibrary.elib.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.elibrary.elib.data.domain.Author;

// AuthorRepository class author @michimel and @RahelHaeusler

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByAuthorID(Long authorID);
    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
    Author findByFirstNameAndLastName(String firstName, String lastName);
    List<Author> findByCountry(String country);
}
