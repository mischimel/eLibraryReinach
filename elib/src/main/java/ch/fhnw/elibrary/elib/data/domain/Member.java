package ch.fhnw.elibrary.elib.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "members")
public class Member {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Hidden
	private Long member_id;
	
    @NotEmpty(message = "Please provide a username.")
	private String username;

    @NotEmpty(message = "Please provide yur firstname.")
	private String firstName;

    @NotEmpty(message = "Please provide your lastname.")
	private String lastName;
	
    @Email(message = "Please provide a valid e-mail.")
	@NotEmpty(message = "Please provide an e-mail.")
	private String email;
	
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // only create object property from JSON
	private String password;
	
    @JsonIgnore
	private String role = "USER"; // default role is USER, but can be set to ADMIN
    
    // INFO: when creating a new member, you can change the role to ADMIN with following code:
    /*
     Member member = new Member();
     member.setRole("ADMIN"); // set the role to ADMIN for this member
     */
	
    @Transient // will not be stored in DB
	@Hidden
	private String remember;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Borrowed> borrowing = new ArrayList<>();

    // constructor
    public Member(Long member_id, String username, String firstName, String lastName, String email, String password, String role) {
        this.member_id = member_id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password; // only create object property from JSON
        this.role = role; // default role is USER, but can be set to ADMIN
    }

    // getters and setters
    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long id) {
        this.member_id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {  
        return email;
    }  

    public void setEmail(String email) {  
        this.email = email;  
    }

    public String getPassword() {  
        return password;  
    }

    public void setPassword(String password) {  
        this.password = password;  
    }

    public String getRole() {  
        return role;  
    }

    public void setRole(String role) {  
        this.role = role;  
    }

    public String getRemember() {  
        return remember;  
    }

    public void setRemember(String remember) {  
        this.remember = remember;  
    }

    // toString
    @Override
    public String toString() {
        return String.format("Member[id=" + member_id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email 
        + ", password=" + password + ", role=" + role + "]");
    }

}

