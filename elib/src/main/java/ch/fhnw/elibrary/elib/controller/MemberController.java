package ch.fhnw.elibrary.elib.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ch.fhnw.elibrary.elib.business.service.MemberService;
import ch.fhnw.elibrary.elib.data.domain.Member;

// MemberController class author @michimel

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // we do not need to implement the security part, as it is taken out of the
    // assignment
    // therefore the mapping is just to add a new member
    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        try {
            member = memberService.createMember(member);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());

        }
        return ResponseEntity.ok(member);
    }

    // to update an existing member, after finding the member by ID, the member is
    // updated with the new values
    @PutMapping(path = "/editProfile/{memberID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Member> updateMember(@PathVariable Long memberID, @RequestBody Member memberDetails) {
        try {
            Member member = memberService.updateMember(memberID, memberDetails);
            return ResponseEntity.ok(member);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /*
     * the following mappings are not used in the application,
     * as budibase provides the functionality to search via the filter function,
     * but for completeness we provide the mappings below
     */

    @GetMapping("/findByUserName/{userName}")
    public Member getMemberByUserName(@PathVariable String userName) {
        return memberService.getMemberByUserName(userName);
    }

    @GetMapping("/findByFirstName/{firstName}")
    public List<Member> getMembersByFirstName(@PathVariable String firstName) {
        return memberService.getMembersByFirstName(firstName);
    }

    @GetMapping("/findByLastName/{lastName}")
    public List<Member> getMembersByLastName(@PathVariable String lastName) {
        return memberService.getMembersByLastName(lastName);
    }

    @GetMapping("/findByFirstNameAndLastName/{firstName}/{lastName}")
    public Member getMemberByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        return memberService.getMemberByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/findByEmail/{email}")
    public Member getMemberByEmail(@PathVariable String email) {
        return memberService.getMemberByEmail(email);
    }

    @GetMapping("/findByRole/{role}")
    public List<Member> getMembersByRole(@PathVariable String role) {
        return memberService.getMembersByRole(role);
    }
}
