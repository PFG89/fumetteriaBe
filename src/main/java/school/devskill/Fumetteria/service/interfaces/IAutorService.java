package school.devskill.Fumetteria.service.interfaces;

import school.devskill.Fumetteria.model.Autor;

import java.util.List;

public interface IAutorService {
    Autor createAutor(Autor newAutor);

    List<Autor> getAutors();

    Autor deleteAutor(Integer id);

    Autor updateAutor(Autor autor);
}
