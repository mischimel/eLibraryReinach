package ch.fhnw.elibrary.elib.business.service;

// Class copied from crm webservice project and adapted to elib project

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ch.fhnw.elibrary.elib.data.domain.Member;

public class UserDetailsImpl implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    
    
    public UserDetailsImpl(Member member) {
    // TODO: uncomment and check with class Member (crm webservice project it is Agent)
        //username=member.getName();
        //password=member.getPassword();
        //authorities.add(new SimpleGrantedAuthority("ROLE_" + member.getRole()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    

}
