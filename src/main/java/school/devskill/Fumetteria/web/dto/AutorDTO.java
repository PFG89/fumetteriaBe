package school.devskill.Fumetteria.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {
    private Integer id;
    private String name;
    private String surname;
}