package ch.fhnw.elibrary.elib.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.elibrary.elib.data.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {  

    /*custom query methods
    - methods with type Book will only return one book (first one found)
    - methods with type List<Book> will return a list with all books found
    author @michimel and @RahelHaeusler*/

    Member findByMember_id(Long member_id);
    List<Member> findByUsername(String username);
    List<Member> findByFirstName(String firstName);
    List<Member> findByLastName(String lastName);
    Member findByFirstNameAndLastName(String firstName, String lastName);
    Member findByEmail(String email);
    List<Member> findByRole(String role);

}
