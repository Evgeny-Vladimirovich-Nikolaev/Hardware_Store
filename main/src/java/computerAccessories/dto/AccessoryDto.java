package computerAccessories.dto;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class AccessoryDto {

    @Id
    private String modelId;

    @NotNull
    @Size(min = 1, max = 7)
    private String code;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal price;

    public String getCodeStr() {
        return String.format("accessory_%s", modelId);
    }

    public String getModelId() {
        return modelId;
    }
}
