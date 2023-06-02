package ch.fhnw.elibrary.elib.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ch.fhnw.elibrary.elib.business.service.BorrowedService;
import ch.fhnw.elibrary.elib.data.domain.Borrowed;

// BorrowedController class author @michimel

@RestController
@RequestMapping("/api/borrowed")
public class BorrowedController {

    @Autowired
    private final BorrowedService borrowedService;

    public BorrowedController(BorrowedService borrowedService) {
        this.borrowedService = borrowedService;
    }

    @GetMapping
    public List<Borrowed> getAllBorrowed() {
        return borrowedService.getAllBorrowed();
    }

    @PostMapping(path = "/rentBook", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Borrowed> createBorrowed(@RequestBody Borrowed borrowed) {
        try {
            borrowed = borrowedService.createBorrowed(borrowed);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());

        }
        return ResponseEntity.ok(borrowed);
    }

    // to update an existing borrowed, after finding the borrowed by ID, the
    // borrowed is updated with the new values
    @PutMapping(path = "/returnBook/{borrowedID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Borrowed> updateBorrowed(@PathVariable Long borrowedID, @RequestBody Borrowed borrowedDetails) {
        try {
            Borrowed borrowed = borrowedService.updateBorrowed(borrowedID, borrowedDetails);
            return ResponseEntity.ok(borrowed);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /*
     * the following mappings are not used in the application,
     * as budibase provides the functionality to search via the filter function,
     * but for completeness we provide the mappings below
     */

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
