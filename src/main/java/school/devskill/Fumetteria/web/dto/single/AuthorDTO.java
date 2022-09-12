package school.devskill.Fumetteria.web.dto.single;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Integer id;
    private String name;
    private String surname;

    public AuthorDTO(Integer id){
        this.id=id;
    }
}
