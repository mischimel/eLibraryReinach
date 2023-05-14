package ch.fhnw.elibrary.elib.business.service;

// Class copied from crm webservice project and adapted to elib project

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ch.fhnw.elibrary.elib.data.domain.Member;
import ch.fhnw.elibrary.elib.data.repository.MemberRepository;



@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
    // TODO: delete this block when block below works and is uncommented
    
        UserDetails user = User.builder()
                            .username(username)
                            .password("password")
                            .authorities("READ","ROLE_USER")
                            .build();   
        return user;
        
    // TODO: uncomment and check with class Member (crm webservice project it is Agent)
        /*
        Member member = memberRepository.findByEmail(username);
        
        if (member == null) {
            throw new UsernameNotFoundException(username);
        }
        
        UserDetails user = User.builder()
                                .username(username)
                                .password(member.getPassword())
                                .authorities("READ","ROLE_" + member.getRole())
                                .build();
        return user; 
        */
        
    }

    
    
}
