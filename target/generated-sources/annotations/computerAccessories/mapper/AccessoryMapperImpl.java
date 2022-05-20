package computerAccessories.mapper;

import computerAccessories.dto.AccessoryDto;
import computerAccessories.model.Accessory;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-20T11:03:04+0300",
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
        accessoryDto.setDescription( entity.getDescription() );
        accessoryDto.setPrice( entity.getPrice() );

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
        accessory.setDescription( dto.getDescription() );
        accessory.setPrice( dto.getPrice() );

        return accessory;
    }

    @Override
    public void update(Accessory accessory, AccessoryDto dto) {
        if ( dto == null ) {
            return;
        }

        accessory.setModelId( dto.getModelId() );
        accessory.setCode( dto.getCode() );
        accessory.setDescription( dto.getDescription() );
        accessory.setPrice( dto.getPrice() );
    }
}
