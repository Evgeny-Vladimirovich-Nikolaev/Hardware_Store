package computerAccessories.mapper;

import computerAccessories.dto.DescriptionDto;
import computerAccessories.model.Description;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(uses = AccessoryMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DescriptionMapper {

    DescriptionDto toDto(Description description);
    Description toEntity(DescriptionDto descriptionDto);

    default List<DescriptionDto> toDescriptionDtos(List<Description> entrances) {
        return entrances.stream().map(this::toDto).collect(Collectors.toList());
    }
}
