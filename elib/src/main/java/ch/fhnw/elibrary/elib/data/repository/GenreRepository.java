package ch.fhnw.elibrary.elib.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.elibrary.elib.data.domain.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
