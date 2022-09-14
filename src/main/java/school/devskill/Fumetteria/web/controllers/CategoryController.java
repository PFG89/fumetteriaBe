package school.devskill.Fumetteria.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.devskill.Fumetteria.model.Category;
import school.devskill.Fumetteria.service.interfaces.ICategoryService;
import school.devskill.Fumetteria.utility.HTTPUtility;
import school.devskill.Fumetteria.web.command.CategoryCommand;
import school.devskill.Fumetteria.web.dto.list.ListCategoryDTO;
import school.devskill.Fumetteria.web.dto.single.CategoryDTO;
import school.devskill.Fumetteria.web.dto.single.UserDTO;


import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryService categoryService;
    private ObjectMapper mapper;

    @Autowired
    public CategoryController(ICategoryService categoryService, ObjectMapper mapper) {
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    @PostMapping(value = HTTPUtility.CREATE)
    public CategoryDTO categoryCreate(@RequestBody CategoryCommand command){
        Category nuovaCategory = mapper.convertValue(command, Category.class);
        return mapper.convertValue(categoryService.createCategory(nuovaCategory), CategoryDTO.class);
    };

    @GetMapping(value = HTTPUtility.LIST)
    public ListCategoryDTO listaCategory() {
        List<Category> categoriesDalDb = categoryService.getCategories();
        ListCategoryDTO ritorno = new ListCategoryDTO();
        for (int i = 0; i < categoriesDalDb.size(); i++) {
            try {
                ritorno.getList().add(mapper.convertValue(categoriesDalDb.get(i), CategoryDTO.class));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return ritorno;
    }


}
