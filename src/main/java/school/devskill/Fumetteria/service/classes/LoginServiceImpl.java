package school.devskill.Fumetteria.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.devskill.Fumetteria.model.User;
import school.devskill.Fumetteria.persistence.repository.ILoginRepository;
import school.devskill.Fumetteria.service.interfaces.ILoginService;
import school.devskill.Fumetteria.web.command.LoginCommand;
import school.devskill.Fumetteria.web.dto.single.UserDTO;

@Service
public class LoginServiceImpl implements ILoginService {

    private final ILoginService loginService;
    private final ILoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(ILoginService loginService, ILoginRepository loginRepository) {
        this.loginService = loginService;
        this.loginRepository = loginRepository;
    }


    @Override
    public User controlloLogin(LoginCommand command) {

            UserDTO userDTO = new UserDTO();
            User user = loginRepository.findByUsername(command.getUsername());

            if (user.getPassword() == command.getPassword() ) {return userDTO
            };


    }
}
