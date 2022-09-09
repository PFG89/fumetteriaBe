package school.devskill.Fumetteria.web.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.devskill.Fumetteria.web.command.LoginCommand;
import school.devskill.Fumetteria.web.dto.single.UserDTO;

@RestController
//@RequestMapping("/login")
public class LoginController {
    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginCommand utente){
        UserDTO user = new UserDTO();
        user.setId(null);
        user.setName(null);
        user.setSurname(null);
        user.setUsername(utente.getUsername());
        return user;
    }
}
