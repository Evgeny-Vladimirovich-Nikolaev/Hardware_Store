package computerAccessories.dto;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class DescriptionDto {
    private Long id;
    private String description;
    private AccessoryDto accessoryDto;
}
