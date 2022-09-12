package school.devskill.Fumetteria.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import school.devskill.Fumetteria.model.Author;

public interface IAuthorRepository extends CrudRepository <Author, Integer>{

   /**
    @Query(value ="SELECT * FROM Autor a WHERE a.id = ?1", nativeQuery = true)
    Autor autorPerId(Integer id);
    **/

}
