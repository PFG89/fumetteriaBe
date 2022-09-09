package school.devskill.Fumetteria.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.devskill.Fumetteria.model.Product;
import school.devskill.Fumetteria.persistence.repository.IAutorRepository;
import school.devskill.Fumetteria.persistence.repository.IProductRepository;
import school.devskill.Fumetteria.service.interfaces.IProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;

    @Autowired
    public ProductServiceImpl(IProductRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>) repository.findAll();
    }
}
