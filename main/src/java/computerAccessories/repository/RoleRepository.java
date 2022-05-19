package computerAccessories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import computerAccessories.model.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByName(String roleName);
}
