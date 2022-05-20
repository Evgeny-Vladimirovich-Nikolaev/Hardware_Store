package computerAccessories.repository;

import computerAccessories.model.Accessory;
import computerAccessories.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface DescriptionRepository extends JpaRepository<Description, Long> {

    Optional<Description> findById(Long id);

}

