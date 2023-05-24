package ch.fhnw.elibrary.elib.data.domain;

import jakarta.persistence.*;

// Borrowed class author @michimel and @RahelHaeusler

@Entity
@Table(name = "borrowed")
public class Borrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long borrowedID;

    @Column(name = "status", nullable = false)
    private Boolean status = true; // default status is true (book is borrowed) when new object is created

    @ManyToOne
    @JoinColumn(name = "bookID", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "memberID", nullable = false)
    private Member member;

    // constructor
    public Borrowed() {  
    }

    public Borrowed(Long borroweID, Book book, Member member, Boolean status) {
        this.borrowedID = borroweID;
        this.book = book;
        this.member = member;
        this.status = status;
    }

    // getters and setters
    public Long getBorrowedID() {
        return borrowedID;
    }

    public void setBorrowedID(Long id) {
        this.borrowedID = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    // toString
    @Override
    public String toString() {
        return String.format("Borrowed[id=" + borrowedID + ", status" + status + ", book=" + book + ", member=" + member + "]");
    }



    
}
