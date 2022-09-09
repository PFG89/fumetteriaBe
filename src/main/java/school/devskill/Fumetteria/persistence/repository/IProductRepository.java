package school.devskill.Fumetteria.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import school.devskill.Fumetteria.model.Product;

public interface IProductRepository extends CrudRepository<Product, Integer> {

}
