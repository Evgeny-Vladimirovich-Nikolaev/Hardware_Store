package computerAccessories.mapper;

import computerAccessories.dto.AccessoryDto;
import computerAccessories.model.Accessory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface AccessoryMapper {

    @Mapping(target = "modelId", source = "entity.modelId")
    @Mapping(target = "code", source = "entity.code")
    @Mapping(target = "description", source = "entity.description")
    @Mapping(target = "price", source = "entity.price")
    AccessoryDto toDto(Accessory entity);

    @Mapping(target = "modelId", source = "dto.modelId")
    @Mapping(target = "code", source = "dto.code")
    @Mapping(target = "description", source = "dto.description")
    @Mapping(target = "price", source = "dto.price")
    Accessory toEntity(AccessoryDto dto);

    @Mapping(target = "accessory.modelId", source = "dto.modelId")
    @Mapping(target = "accessory.code", source = "dto.code")
    @Mapping(target = "accessory.description", source = "dto.description")
    @Mapping(target = "accessory.price", source = "dto.price")
    void update(@MappingTarget Accessory accessory, AccessoryDto dto);

    default List<AccessoryDto> toDtos(List<Accessory> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<AccessoryDto> toOptionalDto(Optional<Accessory> entity) {
        return entity.map(this::toDto);
    }
}
