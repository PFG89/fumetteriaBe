package school.devskill.Fumetteria.web.dto.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.devskill.Fumetteria.web.dto.single.AutorDTO;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListAutorDTO {
    private List<AutorDTO> list = new ArrayList<>();
}
