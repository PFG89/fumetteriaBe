package school.devskill.Fumetteria.web.dto.single;

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

    public AutorDTO(Integer id){
        this.id=id;
    }
}
