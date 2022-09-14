package school.devskill.Fumetteria.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.devskill.Fumetteria.model.User;
import school.devskill.Fumetteria.service.interfaces.ILoginService;
import school.devskill.Fumetteria.web.command.LoginCommand;
import school.devskill.Fumetteria.web.dto.single.UserDTO;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final ILoginService loginService;
    private ObjectMapper mapper;

    @Autowired
    public LoginController(ILoginService loginService, ObjectMapper mapper) {
        this.loginService = loginService;
        this.mapper = mapper;
    }

    @PostMapping("/user")
    public UserDTO login(@RequestBody LoginCommand command){
            return mapper.convertValue(loginService.controlloLogin(command),UserDTO.class);
        };

}
