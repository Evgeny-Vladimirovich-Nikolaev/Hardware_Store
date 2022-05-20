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
    private String type;

    @NotNull
    private BigDecimal price;

    private DescriptionDto description;

    private String descriptionString;

    public String getCodeStr() {
        return String.format("accessory_%s", modelId);
    }

    public String getModelId() {
        return modelId;
    }

    public void writeDescription(String d) {
        description.setDescription(d);
    }
}
