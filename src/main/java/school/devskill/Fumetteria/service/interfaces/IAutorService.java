package school.devskill.Fumetteria.service.interfaces;

import school.devskill.Fumetteria.model.Autor;

import java.util.List;

public interface IAutorService {


    Autor getAutor(Integer id);

    Autor createAutor(Autor newAutor);

    List<Autor> getAutors();

    Autor deleteAutor(Integer id);

    Autor updateAutor(Autor autor);
}
