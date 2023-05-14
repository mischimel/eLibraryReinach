package ch.fhnw.elibrary.elib.data.domain;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "borrowed")
public class Borrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long borrowed_id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // constructor
    public Borrowed(Long borrowe_id, Book book, Member member, LocalDate borrowedDate, LocalDate returnedDate) {
        this.borrowed_id = borrowe_id;
        this.book = book;
        this.member = member;
        this.startDate = borrowedDate;
        this.endDate = returnedDate;
    }

    // getters and setters
    public Long getBorrowed_id() {
        return borrowed_id;
    }

    public void setBorrowed_id(Long id) {
        this.borrowed_id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate borrowedDate) {
        this.startDate = borrowedDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    
    public void setEndDate(LocalDate returnedDate) {
        this.endDate = returnedDate;
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
        return String.format("Borrowed[id=" + borrowed_id + ", startDate=" + startDate + ", endDate=" + endDate + ", book=" + book + ", member=" + member + "]");
    }



    
}
