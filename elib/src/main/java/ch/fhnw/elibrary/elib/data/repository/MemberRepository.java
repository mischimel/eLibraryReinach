package ch.fhnw.elibrary.elib.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.elibrary.elib.data.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {  
}
