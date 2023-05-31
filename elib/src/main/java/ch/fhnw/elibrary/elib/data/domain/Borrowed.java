package ch.fhnw.elibrary.elib.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

// Borrowed class author @michimel and @RahelHaeusler

@Entity
@Table(name = "borrowed")
public class Borrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    // @JsonIgnore // comment out this line to see the borrowedID in the response
    private Long borrowedID;

    @Column(name = "status", nullable = false)
    private Boolean status = true; // default status is true (book is borrowed) when new object is created

    // @Transient, which means they are not persisted in the database but used for
    // computation purposes

    @Transient
    @Column(nullable = false)
    private String bookTitle;

    @Transient
    @Column(nullable = false)
    private String memberUserName;

    @Transient
    @Column(nullable = false)
    private String memberEmail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bookID", nullable = false)
    private Book book;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "memberID", nullable = false)
    private Member member;

    // constructor
    public Borrowed() {
    }

    public Borrowed(Long borroweID, Boolean status, Book book, Member member) {
        this.borrowedID = borroweID;
        this.status = status;
        this.bookTitle = book.getTitle();
        this.memberUserName = member.getUserName();
        this.memberEmail = member.getEmail();
    }

    // getters and setters
    public Long getBorrowedID() {
        return borrowedID;
    }

    public void setBorrowedID(Long id) {
        this.borrowedID = id;
    }

    public Boolean getStatus() {
        return status; // = true; // default status is true (book is borrowed) when new object is
                       // created
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    // Getter and Setter for bookTitle
    public String getBookTitle() {
        if (book != null) {
            return book.getTitle();
        }
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    // Getter and Setter for memberUserName
    public String getMemberUserName() {
        if (member != null) {
            return member.getUserName();
        }
        return memberUserName;
    }

    public void setMemberUserName(String memberUserName) {
        this.memberUserName = memberUserName;
    }

    // Getter and Setter for memberEmail
    public String getMemberEmail() {
        if (member != null) {
            return member.getEmail();
        }
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    @JsonIgnore
    public Book getBook() {
        return book;
    }

    @JsonIgnore
    public void setBook(Book book) {
        this.book = book;
    }

    @JsonIgnore
    public Member getMember() {
        return member;
    }

    @JsonIgnore
    public void setMember(Member member) {
        this.member = member;
    }

    // toString
    @Override
    public String toString() {
        return String.format("Borrowed[id=" + borrowedID + ", status" + status + ", bookTitle=" + bookTitle +
                ", memberUserName=" + memberUserName + ", memberEmail=" + memberEmail + "]");

    }

}
