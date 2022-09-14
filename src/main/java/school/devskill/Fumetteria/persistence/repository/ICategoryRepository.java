package school.devskill.Fumetteria.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import school.devskill.Fumetteria.model.Category;

public interface ICategoryRepository extends CrudRepository<Category, String> {


}
