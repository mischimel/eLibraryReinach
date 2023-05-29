package ch.fhnw.elibrary.elib.business.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ch.fhnw.elibrary.elib.data.domain.Member;
import ch.fhnw.elibrary.elib.data.repository.MemberRepository;

// MemberService class author @michimel

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // we do not need to implement the security part, as it is taken out of the assignment
    // therefore the method is just to add a new member
    // checks if member with the given username and email already exists, if not, the member is saved
    public Member createMember(Member member) throws Exception {
        if (member.getUserName() != null && member.getEmail() != null) {
            if (memberRepository.findByUserName(member.getUserName()) == null && memberRepository.findByEmail(member.getEmail()) == null)
                return memberRepository.save(member);
            else
                throw new Exception("Member " + member.getUserName() +  member.getEmail() + " already exists");
            
        }
        throw new Exception("Invalid member name");
    }


    // public Member createMember(Member member) {
    //     return memberRepository.save(member);
    // }

    public Member updateMember(Long memberId, Member memberDetails) {
        Member member = getMemberById(memberId);
        member.setUserName(memberDetails.getUserName());
        member.setFirstName(memberDetails.getFirstName());
        member.setLastName(memberDetails.getLastName());
        member.setEmail(memberDetails.getEmail());
        member.setPassword(memberDetails.getPassword());
        member.setRole(memberDetails.getRole());
        return memberRepository.save(member);
    }

    /* the following methods are not used in the application, 
    as budibase provides the functionality to search via the filter function,
    but for completeness we provide the methods below */
    
    public Member getMemberByUserName(String userName) {
        return memberRepository.findByUserName(userName);
    }

    public List<Member> getMembersByFirstName(String firstName) {
        return memberRepository.findByFirstName(firstName);
    }

    public List<Member> getMembersByLastName(String lastName) {
        return memberRepository.findByLastName(lastName);
    }

    public Member getMemberByFirstNameAndLastName(String firstName, String lastName) {
        return memberRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public List<Member> getMembersByRole(String role) {
        return memberRepository.findByRole(role);
    }

    private Member getMemberById(Long memberId) {
        return memberRepository.findByMemberID(memberId);
    }
}

