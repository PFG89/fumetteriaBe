package school.devskill.Fumetteria.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import school.devskill.Fumetteria.model.User;

public interface IUserRepository extends CrudRepository<User,Integer> {



}
