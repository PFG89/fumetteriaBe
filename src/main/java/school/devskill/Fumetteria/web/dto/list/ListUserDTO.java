package school.devskill.Fumetteria.web.dto.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.devskill.Fumetteria.web.dto.single.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListUserDTO {
    private List<UserDTO> list = new ArrayList<>();
}
