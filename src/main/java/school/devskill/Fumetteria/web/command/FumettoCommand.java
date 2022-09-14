package school.devskill.Fumetteria.web.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.devskill.Fumetteria.web.dto.single.AuthorDTO;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FumettoCommand {
    private String name;
    private String description;
    private String type;
    private AuthorCommand author;
    private String category;
    private String photo;
    private String pages;
}
