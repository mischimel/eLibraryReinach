package ch.fhnw.elibrary.elib.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.elibrary.elib.data.domain.Borrowed;

@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {

    /*custom query methods
    - methods with type Book will only return one book (first one found)
    - methods with type List<Book> will return a list with all books found
    author @michimel and @RahelHaeusler*/

    Borrowed findByBorrowed_id(Long borrowed_id);
    List<Borrowed> findAll();
    Borrowed findByTitle(String title);
    Borrowed findByIsbn(String isbn);
    List<Borrowed> findByAuthor(String author);
    List<Borrowed> findByGenre(String genre);
    List<Borrowed> findByMember(String member);
    List<Borrowed> findBystart_Date(String start_Date);
    List<Borrowed> findByend_Date(String end_Date);

}
