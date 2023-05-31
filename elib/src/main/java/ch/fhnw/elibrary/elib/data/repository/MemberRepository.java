package ch.fhnw.elibrary.elib.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.elibrary.elib.data.domain.Member;

// MemberRepository class author @michimel and @RahelHaeusler

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemberID(Long memberID);

    Member findByUserName(String userName);

    List<Member> findByFirstName(String firstName);

    List<Member> findByLastName(String lastName);

    Member findByFirstNameAndLastName(String firstName, String lastName);

    Member findByEmail(String email);

    List<Member> findByRole(String role);
    
}
