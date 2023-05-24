package ch.fhnw.elibrary.elib.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.elibrary.elib.data.domain.Borrowed;

// BorrowedRepository class author @michimel and @RahelHaeusler

@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {

    /*custom query methods
    - methods with type Book will only return one book (first one found)
    - methods with type List<Book> will return a list with all books found
    author @michimel and @RahelHaeusler*/

    Borrowed findByBorrowedID(Long borrowedID);
    List<Borrowed> findAll();
    List<Borrowed> findByStatus(Boolean status);
    List<Borrowed> findByBook(String book);
    List<Borrowed> findByMember(String member);
    List<Borrowed> findByMemberAndStatus(String member, Boolean status);
    List<Borrowed> findByBookAndStatus(String book, Boolean status);

}
