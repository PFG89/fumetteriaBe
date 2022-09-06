package school.devskill.Fumetteria.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.devskill.Fumetteria.model.User;
import school.devskill.Fumetteria.persistence.repository.IUserRepository;
import school.devskill.Fumetteria.service.interfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User deleteUser(Integer id) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
