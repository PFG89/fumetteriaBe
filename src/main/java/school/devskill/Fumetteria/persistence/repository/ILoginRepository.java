package school.devskill.Fumetteria.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import school.devskill.Fumetteria.model.User;

public interface ILoginRepository extends CrudRepository <User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);
}
