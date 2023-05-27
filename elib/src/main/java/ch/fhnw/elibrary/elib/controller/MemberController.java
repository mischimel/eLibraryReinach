package ch.fhnw.elibrary.elib.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.fhnw.elibrary.elib.business.service.MemberService;
import ch.fhnw.elibrary.elib.data.domain.Member;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

// MemberController class author @michimel

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    //TODO: we do not need to implement this, as the security part is taken out of the assignment
    @PostMapping("/register")
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PutMapping("/editProfile/{memberId}")
    public Member updateMember(@PathVariable Long memberId, @RequestBody Member member) {
        return memberService.updateMember(memberId, member);
    }

    /* the following mappings are not used in the application, 
    as budibase provides the functionality to search via the filter function,
    but for completeness we provide the mappings below */
    
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

