package school.devskill.Fumetteria.service.interfaces;

import school.devskill.Fumetteria.model.Author;

import java.util.List;

public interface IAuthorService {


    Author getAuthor(Integer id);

    Author createAuthor(Author newAuthor);

    List<Author> getAuthors();

    Author deleteAuthor(Integer id);

    Author updateAuthor(Author author);
}
