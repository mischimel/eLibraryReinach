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
  
    public Borrowed createBorrowed(Borrowed borrowed) throws Exception {
        if (borrowed.getStatus() == null || borrowed.getStatus() != true) {
            throw new Exception("Invalid status. The status must be true.");
        }
    
        String bookTitle = borrowed.getBookTitle();
        String memberUserName = borrowed.getMemberUserName();
    
        // Check whether the book with the specified title exists in the database
        Book book = bookRepository.findByTitle(bookTitle);
        if (book == null) {
            throw new Exception("Book does not exist.");
        }
    
        // Check whether the member with the specified user name exists in the database
        Member member = memberRepository.findByUserName(memberUserName);
        if (member == null) {
            throw new Exception("Member does not exist.");
        }
    
        // Check whether a borrowed object with the same data already exists in the database
        List<Borrowed> borrowedList = borrowedRepository.findAll();
        for (Borrowed b : borrowedList) {
            if (b.getBookTitle().equals(bookTitle) && b.getMemberUserName().equals(memberUserName)) {
                throw new Exception("Book is already borrowed.");
            }
        }
                    
        borrowed.setBook(book);
        borrowed.setMember(member);
        borrowed.setStatus(true);
    
        return borrowedRepository.save(borrowed);
    }
    
    // to update an existing borrowed, after finding the borrowed by ID, the borrowed is updated with the new values
    public Borrowed updateBorrowed(Long borrowedID, Borrowed borrowedDetails) {
        Borrowed borrowed = borrowedRepository.findByBorrowedID(borrowedID);
        if (borrowed == null) {
            throw new RuntimeException("Borrowed not found for this ID :: " + borrowedID);
        }
        borrowed.setStatus(borrowedDetails.getStatus());
        borrowed.setBookTitle(borrowedDetails.getBookTitle());
        borrowed.setMemberUserName(borrowedDetails.getMemberUserName());
        borrowed.setMemberEmail(borrowedDetails.getMemberEmail());
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
