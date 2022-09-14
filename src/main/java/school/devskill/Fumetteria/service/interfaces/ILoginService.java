package school.devskill.Fumetteria.service.interfaces;

import school.devskill.Fumetteria.model.Author;
import school.devskill.Fumetteria.model.User;
import school.devskill.Fumetteria.web.command.LoginCommand;

public interface ILoginService {
    User controlloLogin(LoginCommand command);
}
