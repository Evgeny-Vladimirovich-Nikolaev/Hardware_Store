package computerAccessories.mapper;

import computerAccessories.dto.AccessoryDto;
import computerAccessories.model.Accessory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AccessoryMapper {

    @Mapping(target = "modelId", source = "entity.modelId")
    @Mapping(target = "code", source = "entity.code")
    @Mapping(target = "type", source = "entity.type")
    @Mapping(target = "price", source = "entity.price")
    @Mapping(target = "description", source = "entity.description")
    AccessoryDto toDto(Accessory entity);

    @Mapping(target = "modelId", source = "dto.modelId")
    @Mapping(target = "code", source = "dto.code")
    @Mapping(target = "type", source = "dto.type")
    @Mapping(target = "price", source = "dto.price")
    @Mapping(target = "description", source = "dto.description")
    Accessory toEntity(AccessoryDto dto);

    default List<AccessoryDto> toDtos(List<Accessory> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<AccessoryDto> toOptionalDto(Optional<Accessory> entity) {
        return entity.map(this::toDto);
    }

}
