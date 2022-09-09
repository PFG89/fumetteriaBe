package school.devskill.Fumetteria.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.devskill.Fumetteria.exceptions.UsernameNotFoundException;
import school.devskill.Fumetteria.model.User;
import school.devskill.Fumetteria.persistence.repository.ILoginRepository;
import school.devskill.Fumetteria.persistence.repository.IUserRepository;
import school.devskill.Fumetteria.service.interfaces.ILoginService;
import school.devskill.Fumetteria.service.interfaces.IUserService;
import school.devskill.Fumetteria.web.command.LoginCommand;
import school.devskill.Fumetteria.web.dto.single.UserDTO;

/** @Service
public class LoginServiceImpl implements ILoginService {

    private final IUserService userService;
    private final IUserRepository userRepository;
    private final ILoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(IUserService userService, IUserRepository userRepository, ILoginRepository loginRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
    }

    @Override
    public User controlloLogin(LoginCommand command)
        throws UsernameNotFoundException {
            UserDTO userdto = new UserDTO();
            User user = loginRepository.findByUsername(command.getUsername());
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            if (user.getPassword() == command.getPassword() ) {return userdto
            };
            return new CustomUserDetails(user);

    }

    /** @Override
    public User controlloLogin(@RequestBody LoginCommand utente) {
        List<User> usersDalDb = userService.getUsers();
        ListUserDTO ritorno = new ListUserDTO();
        for (int i = 0; i < usersDalDb.size(); i++) {
            if (utente.getUsername() == usersDalDb.get(i).getUsername() && utente.getPassword() == usersDalDb.get(i).getUsername()) {
                return
            }
        }

    }
        return null;
} **/
