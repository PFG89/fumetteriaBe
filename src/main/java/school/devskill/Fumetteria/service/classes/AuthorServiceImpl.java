package school.devskill.Fumetteria.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.devskill.Fumetteria.model.Author;
import school.devskill.Fumetteria.persistence.repository.IAuthorRepository;
import school.devskill.Fumetteria.service.interfaces.IAuthorService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements IAuthorService {

    private final IAuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author getAuthor(Integer id) {

        return authorRepository.findById(id).get();

    }



    @Override
    public Author createAuthor(Author newAuthor) {
        return authorRepository.save(newAuthor);
    }

    @Override
    public List<Author> getAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author deleteAuthor(Integer id) {
        Author daCancellare;
        try {
            daCancellare = authorRepository.findById(id).get();
            authorRepository.delete(daCancellare);
        } catch (NoSuchElementException e) {
            daCancellare = new Author();
        }
        return daCancellare;
    }

    @Override
    public Author updateAuthor(Author authorAggiornato) {
        Author authorCorrente = authorRepository.findById(authorAggiornato.getId()).get();

        if(authorAggiornato.getName() != null) {
            authorCorrente.setName(authorAggiornato.getName());
        }

        if(authorAggiornato.getSurname() != null) {
            authorCorrente.setSurname(authorAggiornato.getSurname());
        }

        return authorRepository.save(authorCorrente);
    }
}
