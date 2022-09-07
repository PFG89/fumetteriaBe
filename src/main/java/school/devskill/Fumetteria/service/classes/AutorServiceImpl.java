package school.devskill.Fumetteria.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.devskill.Fumetteria.model.Autor;
import school.devskill.Fumetteria.model.User;
import school.devskill.Fumetteria.persistence.repository.IAutorRepository;
import school.devskill.Fumetteria.service.interfaces.IAutorService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AutorServiceImpl implements IAutorService {

    private final IAutorRepository autorRepository;

    @Autowired
    public AutorServiceImpl(IAutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    @Override
    public Autor createAutor(Autor newAutor) {
        return autorRepository.save(newAutor);
    }

    @Override
    public List<Autor> getAutors() {
        return (List<Autor>) autorRepository.findAll();
    }

    @Override
    public Autor deleteAutor(Integer id) {
        Autor daCancellare;
        try {
            daCancellare = autorRepository.findById(id).get();
            autorRepository.delete(daCancellare);
        } catch (NoSuchElementException e) {
            daCancellare = new Autor();
        }
        return daCancellare;
    }

    @Override
    public Autor updateAutor(Autor autorAggiornato) {
        Autor autorCorrente = autorRepository.findById(autorAggiornato.getId()).get();

        if(autorAggiornato.getName() != null) {
            autorCorrente.setName(autorAggiornato.getName());
        }

        if(autorAggiornato.getSurname() != null) {
            autorCorrente.setSurname(autorAggiornato.getSurname());
        }

        return autorRepository.save(autorCorrente);
    }
}
