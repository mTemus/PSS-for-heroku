package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "idRole")
    private Integer idRole;

    @Column(name = "roleName")
    private String roleName;

}
