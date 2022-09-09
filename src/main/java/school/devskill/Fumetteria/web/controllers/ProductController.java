package school.devskill.Fumetteria.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.devskill.Fumetteria.model.Autor;
import school.devskill.Fumetteria.model.Product;
import school.devskill.Fumetteria.service.interfaces.IAutorService;
import school.devskill.Fumetteria.service.interfaces.IProductService;
import school.devskill.Fumetteria.utility.HTTPUtility;
import school.devskill.Fumetteria.web.dto.list.ListFumettoDTO;
import school.devskill.Fumetteria.web.dto.single.FumettoDTO;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IAutorService autorService;
    private final IProductService productService;
    private final ObjectMapper mapper;

    @Autowired
    public ProductController(IAutorService autorService, IProductService productService, ObjectMapper mapper) {
        this.autorService = autorService;
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

       /** for (int i = 0; i < ritorno.getList().size(); i++) {
            try {

                FumettoDTO fumettoCorrente = ritorno.getList().get(i);
                Integer idAutore = fumettoCorrente.getAuthor().getId();
                Autor autor = autorService.getAutor(idAutore);
                fumettoCorrente.getAuthor().setName(autor.getName());
                fumettoCorrente.getAuthor().setSurname(autor.getSurname());

                ritorno.getList().add(mapper.convertValue(productsDalDb.get(i), FumettoDTO.class));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } **/

        return ritorno;
    }

}
