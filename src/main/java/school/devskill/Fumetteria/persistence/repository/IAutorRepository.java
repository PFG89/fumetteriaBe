package school.devskill.Fumetteria.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import school.devskill.Fumetteria.model.Autor;

public interface IAutorRepository extends CrudRepository <Autor, Integer>{

   /**
    @Query(value ="SELECT * FROM Autor a WHERE a.id = ?1", nativeQuery = true)
    Autor autorPerId(Integer id);
    **/

}
