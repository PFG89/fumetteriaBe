package school.devskill.Fumetteria.web.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {
    private String name;
    private String surname;
    private String username;
    private String password;
}
