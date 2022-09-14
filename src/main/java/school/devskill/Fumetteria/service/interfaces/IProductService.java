package school.devskill.Fumetteria.service.interfaces;

import school.devskill.Fumetteria.model.Author;
import school.devskill.Fumetteria.model.Product;

import java.util.List;

public interface IProductService {
public List<Product> getProducts();

Product createProduct(Product newProduct);
}
