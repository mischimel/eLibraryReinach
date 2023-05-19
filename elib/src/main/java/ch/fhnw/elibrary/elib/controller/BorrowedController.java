package ch.fhnw.elibrary.elib.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.fhnw.elibrary.elib.business.service.BorrowedService;
import ch.fhnw.elibrary.elib.data.domain.Borrowed;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

// author @michimel

@RestController
@RequestMapping("/api/borrowed")
public class BorrowedController {

    private final BorrowedService borrowedService;

    public BorrowedController(BorrowedService borrowedService) {
        this.borrowedService = borrowedService;
    }

    @GetMapping
    public List<Borrowed> getAllBorrowed() {
        return borrowedService.getAllBorrowed();
    }

    @PostMapping
    public Borrowed createBorrowed(@RequestBody Borrowed borrowed) {
        return borrowedService.createBorrowed(borrowed);
    }

    @PutMapping("/{borrowedID}")
    public Borrowed updateBorrowed(@PathVariable Long borrowedID, @RequestBody Borrowed borrowed) {
        return borrowedService.updateBorrowed(borrowedID, borrowed);
    }

    @GetMapping("/findByStatus/{status}")
    public List<Borrowed> getBorrowedByStatus(@PathVariable Boolean status) {
        return borrowedService.getBorrowedByStatus(status);
    }

    @GetMapping("/findByBook/{book}")
    public List<Borrowed> getBorrowedByBook(@PathVariable String book) {
        return borrowedService.getBorrowedByBook(book);
    }

    @GetMapping("/findByMember/{member}")
    public List<Borrowed> getBorrowedByMember(@PathVariable String member) {
        return borrowedService.getBorrowedByMember(member);
    }

    @GetMapping("/findByMemberAndStatus/{member}/{status}")
    public List<Borrowed> getBorrowedByMemberAndStatus(@PathVariable String member, @PathVariable Boolean status) {
        return borrowedService.getBorrowedByMemberAndStatus(member, status);
    }

    @GetMapping("/findByBookAndStatus/{book}/{status}")
    public List<Borrowed> getBorrowedByBookAndStatus(@PathVariable String book, @PathVariable Boolean status) {
        return borrowedService.getBorrowedByBookAndStatus(book, status);
    }
}

