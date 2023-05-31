package ch.fhnw.elibrary.elib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.annotation.PostConstruct;
// import org.springframework.boot.context.event.ApplicationReadyEvent;
// import org.springframework.context.event.EventListener;
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

// ElibApplication class - this is the Spring boot Application
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

    // @EventListener(ApplicationReadyEvent.class)
    // public void seedDatabase() {

    @PostConstruct
    private void initPlaceholderData() throws Exception {

        // Pipi Langstrumpf Book, that is borrowed by member(user, not Admin) Michele
        // Fille:
        // Create Author
        Author author1 = new Author();
        author1.setFirstName("Astrid");
        author1.setLastName("Lindgren");
        author1.setCountry("Sweden");
        authorRepository.save(author1);

        // Create Genre
        Genre genre1 = new Genre();
        genre1.setName("Children's Fiction");
        genreRepository.save(genre1);

        // Create Book
        Book book1 = new Book();
        book1.setIsbn("9781234567890");
        book1.setTitle("Pippi Longstocking");
        book1.setPublishYear(1945);
        book1.setDescription("Astrid Lindgren's classic children's novel");
        book1.setAuthor(author1);
        book1.setGenre(genre1);
        bookRepository.save(book1);

        // Create Member
        Member member1 = new Member();
        member1.setUserName("michele_fille");
        member1.setFirstName("Michele");
        member1.setLastName("Fille");
        member1.setEmail("michele.fille@students.fhnw.ch");
        member1.setPassword("password");
        member1.setRole("user");
        memberRepository.save(member1);

        // Create Borrowed
        Borrowed borrowed1 = new Borrowed();
        borrowed1.setStatus(true);
        borrowed1.setBook(book1);
        borrowed1.setMember(member1);
        borrowedRepository.save(borrowed1);

        // Book 2 - not borrowed

        // Create Author
        Author author2 = new Author();
        author2.setFirstName("Nicky");
        author2.setLastName("Pellegrino");
        author2.setCountry("Italy");
        authorRepository.save(author2);

        // Create Genre
        Genre genre2 = new Genre();
        genre2.setName("Love Story");
        genreRepository.save(genre2);

        // Create Book
        Book book2 = new Book();
        book2.setIsbn("978-0-7528-6787-8");
        book2.setTitle("Delicious");
        book2.setPublishYear(2006);
        book2.setDescription("A love story");
        book2.setAuthor(author2);
        book2.setGenre(genre2);
        bookRepository.save(book2);

        // Create member 2 with Admin role
        // Create Member
        Member member2 = new Member();
        member2.setUserName("fillem");
        member2.setFirstName("Michi");
        member2.setLastName("Fille2");
        member2.setEmail("michele.fille@gmail.com");
        member2.setPassword("password");
        member2.setRole("admin");
        memberRepository.save(member2);

    }

}