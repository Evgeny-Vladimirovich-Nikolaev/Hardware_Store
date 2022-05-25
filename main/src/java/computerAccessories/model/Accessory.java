package computerAccessories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hardware_catalogue")
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    @NotEmpty
    private String modelId;

    @NotEmpty
    private String code;

    @NotEmpty
    private String type;

    private BigDecimal price;

    @OneToOne(mappedBy = "accessory", cascade = CascadeType.ALL)
    private Description description;

}
