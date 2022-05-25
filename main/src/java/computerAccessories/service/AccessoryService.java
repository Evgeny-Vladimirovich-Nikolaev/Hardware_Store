package computerAccessories.service;

import computerAccessories.dto.AccessoryDto;
import computerAccessories.dto.AccessoryPageDto;
import org.springframework.data.domain.Pageable;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface AccessoryService {

    List<AccessoryDto> findAll();

    AccessoryPageDto getPage(Pageable pageable);

    AccessoryPageDto getPage(Pageable pageable, String type);

    AccessoryPageDto getPage(Pageable pageable, String type, String vendor);

    Optional<AccessoryDto> getByModelId(@NotEmpty String modelId);

    AccessoryDto save(@Valid AccessoryDto accessory);

    void deleteByCode(@NotEmpty String modelId);

}
