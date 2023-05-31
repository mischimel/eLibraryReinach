package ch.fhnw.elibrary.elib.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.elibrary.elib.data.domain.Book;

// BookRepository class author @michimel and @RahelHaeusler

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByBookID(Long bookID);

    List<Book> findAll();

    Book findByTitle(String title);

    Book findByIsbn(String isbn);

    List<Book> findByPublishYear(int publishYear);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

}