package ch.fhnw.elibrary.elib.data.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

// Member class author @michimel and @RahelHaeusler

@Entity
@Table(name = "members")
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberID;

    @NotEmpty(message = "Please provide a username.")
    private String userName;

    @NotEmpty(message = "Please provide yur firstname.")
    private String firstName;

    @NotEmpty(message = "Please provide your lastname.")
    private String lastName;

    @Email(message = "Please provide a valid e-mail.")
    @NotEmpty(message = "Please provide an e-mail.")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // only create object property from JSON
    @JsonIgnore
    private String password;

    @JsonIgnore
    private String role; // = "USER"; // default role is USER, but can be set to ADMIN

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "borrowed", joinColumns = @JoinColumn(name = "memberID"), inverseJoinColumns = @JoinColumn(name = "bookID"))
    private List<Borrowed> borrowing;

    // constructor
    public Member() {
    }

    public Member(Long memberID, String userName, String firstName, String lastName, String email, String password, String role) {
        this.memberID = memberID;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password; // only create object property from JSON
        this.role = role; // default role is USER, but can be set to ADMIN
    }

    // getters and setters
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long id) {
        this.memberID = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    // toString
    @Override
    public String toString() {
        return String.format("Member[id=" + memberID + ", username=" + userName + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email
                + ", password=" + password + ", role=" + role + "]");
    }

}
