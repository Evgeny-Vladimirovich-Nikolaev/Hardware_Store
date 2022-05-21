package computerAccessories.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DescriptionDto {

    @NotNull
    private Long id;

    private String description;

    private AccessoryDto accessoryDto;

}
