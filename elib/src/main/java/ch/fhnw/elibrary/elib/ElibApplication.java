package ch.fhnw.elibrary.elib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ch.fhnw.elibrary.elib.data.domain.Book;
import ch.fhnw.elibrary.elib.data.domain.Genre;
import ch.fhnw.elibrary.elib.data.domain.Author;
import ch.fhnw.elibrary.elib.data.domain.Member;
import ch.fhnw.elibrary.elib.data.domain.Borrowed;
import ch.fhnw.elibrary.elib.data.repository.AuthorRepository;
import ch.fhnw.elibrary.elib.data.repository.BookRepository;
import ch.fhnw.elibrary.elib.data.repository.GenreRepository;
import ch.fhnw.elibrary.elib.data.repository.MemberRepository;
import ch.fhnw.elibrary.elib.data.repository.BorrowedRepository;

// author @michimel

@SpringBootApplication
public class ElibApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElibApplication.class, args);
	}

	@Autowired
private BookRepository bookRepository;

@Autowired
private AuthorRepository authorRepository;

@Autowired
private GenreRepository genreRepository;

@Autowired
private MemberRepository memberRepository;

@Autowired
private BorrowedRepository borrowedRepository;

@EventListener(ApplicationReadyEvent.class)
public void seedDatabase() {

// Pipi Langstrumpf Book, that is borrowed by member(user, not Admin) Michele Fille: 
    // Create Author
    Author author = new Author();
    author.setFirstName("Astrid");
    author.setLastName("Lindgren");
    author.setCountry("Sweden");
    authorRepository.save(author);

    // Create Genre
    Genre genre = new Genre();
    genre.setName("Children's Fiction");
    genreRepository.save(genre);

    // Create Book
    Book book = new Book();
    book.setIsbn("9781234567890");
    book.setTitle("Pippi Longstocking");
    book.setPublishYear(1945);
    book.setDescription("Astrid Lindgren's classic children's novel");
    book.setAuthor(author);
    book.setGenre(genre);
    bookRepository.save(book);

    // Create Member
    Member member = new Member();
    member.setUserName("michele_fille");
    member.setFirstName("Michele");
    member.setLastName("Fille");
    member.setEmail("michele.fille@students.fhnw.ch");
    member.setPassword("password"); 
    member.setRole("user");
    memberRepository.save(member);

    // Create Borrowed
    Borrowed borrowed = new Borrowed();
    borrowed.setStatus(true);
    borrowed.setBook(book);
    borrowed.setMember(member);
    borrowedRepository.save(borrowed);
}


}