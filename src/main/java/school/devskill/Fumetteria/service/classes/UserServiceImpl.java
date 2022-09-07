package school.devskill.Fumetteria.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.devskill.Fumetteria.model.User;
import school.devskill.Fumetteria.persistence.repository.IUserRepository;
import school.devskill.Fumetteria.service.interfaces.IUserService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {

        return (List<User>) userRepository.findAll();
    }

    @Override
    public User createUser(User newUser) {

        return userRepository.save(newUser);
    }

    @Override
    public User deleteUser(Integer id) {
        User daCancellare;
        try {
            daCancellare = userRepository.findById(id).get();
            userRepository.delete(daCancellare);
        } catch (NoSuchElementException e) {
            daCancellare = new User();
        }
        return daCancellare;
    }

    @Override
    public User updateUser(User userAggiornato) {
        User userCorrente = userRepository.findById(userAggiornato.getId()).get();

        if(userAggiornato.getName() != null) {
            userCorrente.setName(userAggiornato.getName());
        }

        if(userAggiornato.getSurname() != null) {
            userCorrente.setSurname(userAggiornato.getSurname());
        }

        if(userAggiornato.getUsername() != null) {
            userCorrente.setUsername(userAggiornato.getUsername());
        }

        if(userAggiornato.getPassword() != null) {
            userCorrente.setPassword(userAggiornato.getPassword());
        }

        return userRepository.save(userCorrente);
    }
    }

