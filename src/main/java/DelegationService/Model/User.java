package DelegationService.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status")
    private Boolean status = true;

    @Column(name = "registrationDate")
    private Date registrationDate = new Date();


    @Column(name = "roleName")
    @ManyToMany
    @JoinColumn(name = "roleName")
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "")
    private List<Delegation> delegation;

    public User(){}

    public User(String companyName, String companyAddress, String companyNip, String name, String lastName, String email, String password){
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyNip = companyNip;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
