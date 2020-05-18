package DelegationService.Model;

import DelegationService.Other.RoleTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "\"Role\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "roleName")
    private RoleTypes roleName;
}
