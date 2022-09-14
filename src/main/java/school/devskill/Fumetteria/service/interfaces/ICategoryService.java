package school.devskill.Fumetteria.service.interfaces;

import school.devskill.Fumetteria.model.Author;
import school.devskill.Fumetteria.model.Category;
import school.devskill.Fumetteria.model.User;

import java.util.List;

public interface ICategoryService {
    Category createCategory(Category newCategory);
    List<Category> getCategories();




}
