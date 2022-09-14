package school.devskill.Fumetteria.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import school.devskill.Fumetteria.model.User;

public interface ILoginRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT u FROM User u WHERE u.username= ?1", nativeQuery = true)
    User findByUsername(String username);
}
