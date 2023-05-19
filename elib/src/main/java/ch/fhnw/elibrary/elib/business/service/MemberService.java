package ch.fhnw.elibrary.elib.business.service;


import java.util.List;
import org.springframework.stereotype.Service;
import ch.fhnw.elibrary.elib.data.domain.Member;
import ch.fhnw.elibrary.elib.data.repository.MemberRepository;

// author @michimel

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long memberId, Member memberDetails) {
        Member member = getMemberById(memberId);
        member.setUserName(memberDetails.getUserName());
        member.setFirstName(memberDetails.getFirstName());
        member.setLastName(memberDetails.getLastName());
        member.setEmail(memberDetails.getEmail());
        member.setPassword(memberDetails.getPassword());
        member.setRole(memberDetails.getRole());
        member.setRemember(memberDetails.getRemember());
        return memberRepository.save(member);
    }

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

