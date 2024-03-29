package computerAccessories.service.impl;

import computerAccessories.dto.AccessoryDto;
import computerAccessories.dto.AccessoryPageDto;
import computerAccessories.mapper.AccessoryMapper;
import computerAccessories.model.Accessory;
import computerAccessories.model.Description;
import computerAccessories.repository.AccessoryRepository;
import computerAccessories.repository.DescriptionRepository;
import computerAccessories.service.AccessoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccessoryServiceImpl implements AccessoryService {

    private final AccessoryRepository accessoryRepository;
    private final AccessoryMapper accessoryMapper;
    private final DescriptionRepository descriptionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AccessoryDto> findAll() {
        return accessoryMapper.toDtos(accessoryRepository.findAll());
    }

    @Override
    public AccessoryPageDto getPage(Pageable pageable) {
        Page<Accessory> currentPage = accessoryRepository.findAll(pageable);
        return new AccessoryPageDto(accessoryMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    public AccessoryPageDto getPage(Pageable pageable, String type) {
        Page<Accessory> currentPage = accessoryRepository.findAllByType(pageable, type);
        return new AccessoryPageDto(accessoryMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    public AccessoryPageDto getPage(Pageable pageable, String type, String vendor) {
        Page<Accessory> currentPage = accessoryRepository.findAllByTypeAndVendor(pageable, type, vendor);
        return new AccessoryPageDto(accessoryMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AccessoryDto> getByModelId(@NotEmpty String modelId) {
        return accessoryMapper.toOptionalDto(
                accessoryRepository.findByModelId(modelId));
    }

    @Override
    @Transactional
    public AccessoryDto save(@Valid AccessoryDto accessoryDto) {
        String modelId = accessoryDto.getModelId();
        Accessory accessory = accessoryMapper.toEntity(accessoryDto);
        Description description = new Description();
        description.setDescription(accessoryDto.getDescriptionString());
        description.setAccessory(accessory);
        accessoryRepository.findByModelId(modelId).ifPresent(
                        a -> {accessory.setId(a.getId());
                        description.setId(a.getId());});
        descriptionRepository.save(description);
        return accessoryMapper.toDto(accessoryRepository.save(accessory));
    }

    @Override
    @Transactional
    public void deleteByCode(@NotEmpty String modelId) {
        log.info("Удаляется модель с кодом {}", modelId);
        accessoryRepository.delete(accessoryRepository.findByModelId(modelId).orElseThrow());
    }

}

