package DelegationService.Repository;

import DelegationService.Model.Delegation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DelegationRepository extends JpaRepository<Delegation, Integer> {
}
