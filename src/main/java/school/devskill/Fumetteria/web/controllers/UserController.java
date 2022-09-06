package school.devskill.Fumetteria.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.devskill.Fumetteria.model.User;
import school.devskill.Fumetteria.service.interfaces.IUserService;
import school.devskill.Fumetteria.utility.HTTPUtility;
import school.devskill.Fumetteria.web.command.UserCommand;
import school.devskill.Fumetteria.web.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;
    private ObjectMapper mapper;

    @Autowired
    public UserController(IUserService userService, ObjectMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping(value = HTTPUtility.CREATE)
    public UserDTO userCreate(@RequestBody UserCommand command){
        User nuovoUser = mapper.convertValue(command,User.class);
        return mapper.convertValue(userService.createUser(nuovoUser),UserDTO.class);
    };

    @GetMapping(value = HTTPUtility.GET)
    public List<UserDTO> listaUtenti() {
        List<User> usersDalDb = userService.getUsers();
        List<UserDTO> ritorno = new ArrayList<>();
        for (int i = 0; i < usersDalDb.size(); i++) {
            try {
                ritorno.add(mapper.convertValue(usersDalDb.get(i), UserDTO.class));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return ritorno;
    }

    @DeleteMapping(value = HTTPUtility.DELETE)
    public UserDTO userDelete(@PathVariable Integer id){

        return mapper.convertValue(userService.deleteUser(id),UserDTO.class);
    };

    @PutMapping(value = HTTPUtility.UPDATE)
    public UserDTO userUpdate(@PathVariable("id") Integer id, @RequestBody UserCommand command){
        User daModificare = mapper.convertValue(command,User.class);
        daModificare.setId(id);
        return mapper.convertValue(userService.updateUser(daModificare), UserDTO.class);
    };
}
