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
    @JsonIgnore //TODO: check if this is needed
    private Long borrowedID;

    @Column(name = "status", nullable = false)
    private Boolean status = true; // default status is true (book is borrowed) when new object is created

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bookID", nullable = false)
    private Book book;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "memberID", nullable = false)
    private Member member;


    // @Transient, which means they are not persisted in the database but used for computation purposes

    @Transient
    @Column(nullable = false)
    private String bookTitle;

    @Transient
    @Column(nullable = false)
    private String authorName;

    @Transient
    @Column(nullable = false)
    private String genreName;

    @Transient
    @Column(nullable = false)
    private String memberUserName;

    @Transient
    @Column(nullable = false)
    private String memberName;

    @Transient
    @Column(nullable = false)
    private String memberEmail;


    // constructor
    public Borrowed() {  
    }

    public Borrowed(Long borroweID, Boolean status, Book book, Member member) {
        this.borrowedID = borroweID;
        this.status = status;
        this.bookTitle = book.getTitle();
        this.authorName = book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();
        this.genreName = book.getGenre().getName();
        this.memberUserName = member.getUserName();
        this.memberName = member.getFirstName() + " " + member.getLastName();
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

    // Getter and Setter for authorName
    public String getAuthorName() {
        if (book != null) {
            return book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();
        }
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    // Getter and Setter for genreName
    public String getGenreName() {
        if (book != null) {
            return book.getGenre().getName();
        }
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
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

    // Getter and Setter for memberName
    public String getMemberName() {
        if (member != null) {
            return member.getFirstName() + " " + member.getLastName();
        }
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
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

    // toString
    @Override
    public String toString() {
        return String.format("Borrowed[id=" + borrowedID + ", status" + status + ", bookTitle=" + bookTitle + 
        ", authorName=" + authorName + ", genreName=" + genreName + ", memberUserName=" + memberUserName + 
        ", memberName=" + memberName + ", memberEmail=" + memberEmail + "]");
        
    }



    
}
