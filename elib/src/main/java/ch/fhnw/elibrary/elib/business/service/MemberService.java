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

    // we do not need to implement the security part, as it is taken out of the
    // assignment
    // therefore the method is just to add a new member
    // checks if member with the given username and email already exists, if not,
    // the member is saved
    public Member createMember(Member member) throws Exception {
        if (member.getUserName() != null && member.getEmail() != null) {
            if (memberRepository.findByUserName(member.getUserName()) == null
                    && memberRepository.findByEmail(member.getEmail()) == null)
                return memberRepository.save(member);
            else
                throw new Exception("Member " + member.getUserName() + member.getEmail() + " already exists");

        }
        throw new Exception("Invalid member name");
    }

    // to update an existing member, after finding the member by ID, the member is
    // updated with the new values
    public Member updateMember(Long memberID, Member memberDetails) {
        Member member = memberRepository.findByMemberID(memberID);
        if (member == null) {
            throw new RuntimeException("Member not found for this ID :: " + memberID);
        }
        member.setUserName(memberDetails.getUserName());
        member.setFirstName(memberDetails.getFirstName());
        member.setLastName(memberDetails.getLastName());
        member.setEmail(memberDetails.getEmail());
        member.setPassword(memberDetails.getPassword());
        return memberRepository.save(member);
    }


    /*
     * the following methods are not used in the application,
     * as budibase provides the functionality to search via the filter function,
     * but for completeness we provide the methods below
     */

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

    private Member getMemberByID(Long memberID) {
        return memberRepository.findByMemberID(memberID);
    }
}
