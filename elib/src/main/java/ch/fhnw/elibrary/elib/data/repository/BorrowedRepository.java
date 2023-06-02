package ch.fhnw.elibrary.elib.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.elibrary.elib.data.domain.Borrowed;

// BorrowedRepository class author @michimel and @RahelHaeusler

@Repository  //annotation is unnecessary for this interface, as Spring Boot can detect and create the repository bean without it
public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {

    Borrowed findByBorrowedID(Long borrowedID);

    List<Borrowed> findAll();

    List<Borrowed> findByStatus(Boolean status);

    List<Borrowed> findByBook(String book);

    List<Borrowed> findByMember(String member);

    Borrowed findByBookAndMember(String book, String member);

    List<Borrowed> findByMemberAndStatus(String member, Boolean status);

    List<Borrowed> findByBookAndStatus(String book, Boolean status);

    Borrowed findByBookAndMemberAndStatus(String book, String member, Boolean status);

}
