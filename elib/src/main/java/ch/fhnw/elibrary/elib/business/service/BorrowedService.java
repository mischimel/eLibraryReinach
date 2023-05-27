package ch.fhnw.elibrary.elib.business.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ch.fhnw.elibrary.elib.data.domain.Borrowed;
import ch.fhnw.elibrary.elib.data.repository.BorrowedRepository;

// BorrowedService class author @michimel

@Service
public class BorrowedService {

    private final BorrowedRepository borrowedRepository;

    public BorrowedService(BorrowedRepository borrowedRepository) {
        this.borrowedRepository = borrowedRepository;
    }

    public List<Borrowed> getAllBorrowed() {
        List<Borrowed> borroweds = borrowedRepository.findAll();

        for (Borrowed borrowed : borroweds) {

            borrowed.setBookTitle(borrowed.getBook().getTitle());
            borrowed.setAuthorName(borrowed.getBook().getAuthor().getFirstName() + " " + borrowed.getBook().getAuthor().getLastName());
            borrowed.setGenreName(borrowed.getBook().getGenre().getName());
            borrowed.setMemberUserName(borrowed.getMember().getUserName());
            borrowed.setMemberName(borrowed.getMember().getFirstName() + " " + borrowed.getMember().getLastName());
            borrowed.setMemberEmail(borrowed.getMember().getEmail());

            // Set the book and member to null to exclude them from JSON serialization
            borrowed.setBook(null);
            borrowed.setMember(null);

        }
        return borroweds;
    }

    public Borrowed createBorrowed(Borrowed borrowed) {
        return borrowedRepository.save(borrowed);
    }

    public Borrowed updateBorrowed(Long borrowedID, Borrowed borrowedDetails) {
        Borrowed borrowed = getBorrowedById(borrowedID);
        borrowed.setStatus(borrowedDetails.getStatus());
        borrowed.setBook(borrowedDetails.getBook());
        borrowed.setMember(borrowedDetails.getMember());
        return borrowedRepository.save(borrowed);
    }

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
