package school.devskill.Fumetteria.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import school.devskill.Fumetteria.model.Product;


import java.util.List;

public interface IProductRepository extends CrudRepository<Product, Integer> {

   /** @Query(value = "SELECT * FROM Product", nativeQuery = true)
    List<Product> listaProdotti;

    // listaProdotti viene richiamato in ProductServiceImpl al posto del motodo .findAll();

     **/

}
