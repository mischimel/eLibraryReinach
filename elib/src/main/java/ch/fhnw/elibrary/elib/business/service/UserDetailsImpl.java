// Security part not implemented, as requirements for assignment changed 

// package ch.fhnw.elibrary.elib.business.service;

// import java.util.Collection;
// import java.util.List;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import ch.fhnw.elibrary.elib.data.domain.Member;

//    /* UserDetailsImpl class copied from crm webservice project and adapted to elib project
//     author of adaption @michimel*/

// public class UserDetailsImpl implements UserDetails {
//     private String username;
//     private String password;
//     private List<GrantedAuthority> authorities;


//     public UserDetailsImpl(Member member) {
//         username=member.getUserName();
//         password=member.getPassword();
//         authorities.add(new SimpleGrantedAuthority("ROLE_" + member.getRole()));
//     }

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         // Auto-generated method stub
//         return authorities;
//     }

//     @Override
//     public String getPassword() {
//         // Auto-generated method stub
//         return password;
//     }

//     @Override
//     public String getUsername() {
//         // Auto-generated method stub
//         return username;
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         // Auto-generated method stub
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         // Auto-generated method stub
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         // Auto-generated method stub
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         // Auto-generated method stub
//         return true;
//     }
    

// }
