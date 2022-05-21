package computerAccessories.mapper;

import computerAccessories.dto.AccessoryDto;
import computerAccessories.dto.DescriptionDto;
import computerAccessories.model.Accessory;
import computerAccessories.model.Description;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-21T17:14:55+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class AccessoryMapperImpl implements AccessoryMapper {

    @Override
    public AccessoryDto toDto(Accessory entity) {
        if ( entity == null ) {
            return null;
        }

        AccessoryDto accessoryDto = new AccessoryDto();

        accessoryDto.setModelId( entity.getModelId() );
        accessoryDto.setCode( entity.getCode() );
        accessoryDto.setType( entity.getType() );
        accessoryDto.setPrice( entity.getPrice() );
        accessoryDto.setDescription( descriptionToDescriptionDto( entity.getDescription() ) );

        return accessoryDto;
    }

    @Override
    public Accessory toEntity(AccessoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        Accessory accessory = new Accessory();

        accessory.setModelId( dto.getModelId() );
        accessory.setCode( dto.getCode() );
        accessory.setType( dto.getType() );
        accessory.setPrice( dto.getPrice() );
        accessory.setDescription( descriptionDtoToDescription( dto.getDescription() ) );

        return accessory;
    }

    protected DescriptionDto descriptionToDescriptionDto(Description description) {
        if ( description == null ) {
            return null;
        }

        DescriptionDto descriptionDto = new DescriptionDto();

        descriptionDto.setId( description.getId() );
        descriptionDto.setDescription( description.getDescription() );

        return descriptionDto;
    }

    protected Description descriptionDtoToDescription(DescriptionDto descriptionDto) {
        if ( descriptionDto == null ) {
            return null;
        }

        Description description = new Description();

        description.setId( descriptionDto.getId() );
        description.setDescription( descriptionDto.getDescription() );

        return description;
    }
}
