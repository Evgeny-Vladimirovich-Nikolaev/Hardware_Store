package computerAccessories.repository;

import computerAccessories.model.Accessory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface AccessoryRepository extends JpaRepository<Accessory, Long> {

    @Query("select a from Accessory a where a.modelId = :modelId")
    Optional<Accessory> findByModelId(String modelId);

    @Query("select a from Accessory a where a.type = :type")
    Page<Accessory> findAllByType(Pageable pageable, String type);

    @Query("select a from Accessory a where a.type = :type and a.code = :vendor")
    Page<Accessory> findAllByTypeAndVendor(Pageable pageable, String type, String vendor);

}

