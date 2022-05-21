package computerAccessories.repository;

import computerAccessories.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DescriptionRepository extends JpaRepository<Description, Long> {

    Optional<Description> findById(Long id);

}

