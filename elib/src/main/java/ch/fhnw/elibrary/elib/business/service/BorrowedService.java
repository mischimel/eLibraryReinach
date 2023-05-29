package ch.fhnw.elibrary.elib.business.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ch.fhnw.elibrary.elib.data.domain.Borrowed;
import ch.fhnw.elibrary.elib.data.domain.Book;
import ch.fhnw.elibrary.elib.data.domain.Member;
import ch.fhnw.elibrary.elib.data.repository.BorrowedRepository;
import ch.fhnw.elibrary.elib.data.repository.BookRepository;
import ch.fhnw.elibrary.elib.data.repository.MemberRepository;

// BorrowedService class author @michimel

@Service
public class BorrowedService {

    private final BorrowedRepository borrowedRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public BorrowedService(BorrowedRepository borrowedRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.borrowedRepository = borrowedRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public List<Borrowed> getAllBorrowed() {
        List<Borrowed> borroweds = borrowedRepository.findAll();
        return borroweds;
    }

    // TODO** for post mapping - conflict is thrown in budibase
    public Borrowed createBorrowed(Borrowed borrowed) throws Exception {
        if (borrowed.getBook() != null && borrowed.getMember() != null) {
            if (bookRepository.findByTitle(borrowed.getBookTitle()) != null && memberRepository.findByUserName(borrowed.getMemberUserName()) != null) {
                Book book = bookRepository.findByTitle(borrowed.getBookTitle());
                Member member = memberRepository.findByFirstNameAndLastName(borrowed.getMember().getFirstName(), borrowed.getMember().getLastName());
                if (borrowedRepository.findByBookAndMemberAndStatus(book.getTitle(), member.getUserName(), true) == null) {
                    borrowed.setBookTitle(book.getTitle());
                    borrowed.setMemberUserName(member.getUserName());
                    borrowed.setStatus(true);
                    return borrowedRepository.save(borrowed);
                }
                else
                    throw new Exception("Book is already borrowed");
            }
            else
                throw new Exception("Book or Member does not exist");
        }
        else
            throw new Exception("Book or Member is null");
    }
  

    public Borrowed updateBorrowed(Long borrowedID, Borrowed borrowedDetails) {
        Borrowed borrowed = getBorrowedById(borrowedID);
        borrowed.setStatus(borrowedDetails.getStatus());
        borrowed.setBook(borrowedDetails.getBook());
        borrowed.setMember(borrowedDetails.getMember());
        return borrowedRepository.save(borrowed);
    }

    /* the following methods are not used in the application, 
    as budibase provides the functionality to search via the filter function,
    but for completeness we provide the methods below */
    
    public List<Borrowed> getBorrowedByStatus(Boolean status) {
        return borrowedRepository.findByStatus(status);
    }

    public List<Borrowed> getBorrowedByBook(String book) {
        return borrowedRepository.findByBook(book);
    }

    public List<Borrowed> getBorrowedByMember(String member) {
        return borrowedRepository.findByMember(member);
    }

    public List<Borrowed> getBorrowedByMemberAndStatus(String member, Boolean status) {
        return borrowedRepository.findByMemberAndStatus(member, status);
    }

    public List<Borrowed> getBorrowedByBookAndStatus(String book, Boolean status) {
        return borrowedRepository.findByBookAndStatus(book, status);
    }

    private Borrowed getBorrowedById(Long borrowedID) {
        return borrowedRepository.findByBorrowedID(borrowedID);
    }
}
