package DelegationService.Repository;

import DelegationService.Model.Role;
import DelegationService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRoles(Role role);
}
