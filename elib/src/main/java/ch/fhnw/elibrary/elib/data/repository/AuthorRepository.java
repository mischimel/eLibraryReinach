package ch.fhnw.elibrary.elib.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.elibrary.elib.data.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
