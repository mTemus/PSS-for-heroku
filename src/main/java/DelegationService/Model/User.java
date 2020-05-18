package DelegationService.Model;

import DelegationService.Other.RoleTypes;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "User")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "iduser")
    private Integer iduser;


    @Column(name = "companyName", nullable = false)
    private String companyName;


    @Column(name = "companyAddress", nullable = false)
    private String companyAddress;


    @Column(name = "comapnyNip", nullable = false)
    private String companyNip;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Wrong Email")
    private String email;


    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "Password must contain: one digit, at least one upper case letter, at least one lower case letter, at least 8 characters without whitespaces")
    @Column(name = "password", nullable = false)
    private String password;


    @Column(name = "status")
    private Boolean status = true;

    @Column(name = "registrationDate")
    private Date registrationDate = new Date();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleName")
    private Set<Role> roles;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Delegation> delegation;


    public User(){
        delegation = new ArrayList<>();
    }

    public User(String companyName, String companyAddress, String companyNip, String name, String lastName, String email, String password){
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyNip = companyNip;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

        delegation = new ArrayList<>();
    }

}
