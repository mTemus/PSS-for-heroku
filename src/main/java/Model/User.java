package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "idUser")
    private Integer idUser;
    @Column(name = "companyName", nullable = false)
    private String companyName;
    @Column(name = "companyAddress", nullable = false)
    private String companyAddress;
    @Column(name = "companyNip", nullable = false)
    private String companyNip;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "status")
    private boolean status; // może int
    @Column(name = "registrationDate")
    private Date registrationDate;
    @Column(name = "role")
    private Set<Role> role;
}
