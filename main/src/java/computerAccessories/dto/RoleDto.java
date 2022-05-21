package computerAccessories.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RoleDto {

    @NotNull
    private long id;

    @NotEmpty
    private String name;


    private List<UserDto> user;

}
