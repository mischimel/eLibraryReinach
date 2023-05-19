package ch.fhnw.elibrary.elib.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.elibrary.elib.data.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /*custom query methods
    - methods with type Book will only return one book (first one found)
    - methods with type List<Book> will return a list with all books found
    author @michimel and @RahelHaeusler*/

    Book findByBookID(Long bookID);
    List<Book> findAll();
    List<Book> findByTitle(String title);
    Book findByIsbn(String isbn);
    List<Book> findByPublishYear(int publishYear);
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);

}