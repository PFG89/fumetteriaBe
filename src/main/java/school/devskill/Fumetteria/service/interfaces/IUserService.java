package school.devskill.Fumetteria.service.interfaces;

import school.devskill.Fumetteria.model.User;

import java.util.List;

public interface IUserService {

    User createUser(User newUser);

    List<User> getUsers();

    User deleteUser(Integer id);

    User updateUser(User user);
}
