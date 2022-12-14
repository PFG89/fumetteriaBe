package school.devskill.Fumetteria.web.dto.single;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FumettoDTO {
    private String id;
    private String name;
    private String description;
    private String type;
    private AuthorDTO author;
    private String category;
    private String  photo = null;
    private String  pages;

}
