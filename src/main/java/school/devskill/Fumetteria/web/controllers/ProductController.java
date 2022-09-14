package school.devskill.Fumetteria.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.devskill.Fumetteria.model.Author;
import school.devskill.Fumetteria.model.Product;
import school.devskill.Fumetteria.service.interfaces.IAuthorService;
import school.devskill.Fumetteria.service.interfaces.IProductService;
import school.devskill.Fumetteria.utility.HTTPUtility;
import school.devskill.Fumetteria.web.command.AuthorCommand;
import school.devskill.Fumetteria.web.command.FumettoCommand;
import school.devskill.Fumetteria.web.dto.list.ListFumettoDTO;
import school.devskill.Fumetteria.web.dto.single.AuthorDTO;
import school.devskill.Fumetteria.web.dto.single.FumettoDTO;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IAuthorService authorService;
    private final IProductService productService;
    private final ObjectMapper mapper;

    @Autowired
    public ProductController(IAuthorService authorService, IProductService productService, ObjectMapper mapper) {
        this.authorService = authorService;
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping(value = HTTPUtility.LIST)
    public ListFumettoDTO listaFumetti(){
        List<Product> productsDalDb = productService.getProducts();
        ListFumettoDTO ritorno = new ListFumettoDTO();
        for (int i = 0; i < productsDalDb.size(); i++) {
            try {
                ritorno.getList().add(mapper.convertValue(productsDalDb.get(i), FumettoDTO.class));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < ritorno.getList().size(); i++) {
            try {

                FumettoDTO fumettoCorrente = ritorno.getList().get(i);
                Integer idAutore = fumettoCorrente.getAuthor().getId();
                Author author = authorService.getAuthor(idAutore);
                fumettoCorrente.getAuthor().setName(author.getName());
                fumettoCorrente.getAuthor().setSurname(author.getSurname());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        return ritorno;
    }

    @PostMapping(value = HTTPUtility.CREATE)
    public FumettoDTO fumettoCreate(@RequestBody FumettoCommand command){
        Product nuovoProduct = mapper.convertValue(command, Product.class);
        return mapper.convertValue(productService.createProduct(nuovoProduct), FumettoDTO.class);
    };

}
