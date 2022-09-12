package school.devskill.Fumetteria.web.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.devskill.Fumetteria.model.Author;
import school.devskill.Fumetteria.service.interfaces.IAuthorService;
import school.devskill.Fumetteria.utility.HTTPUtility;
import school.devskill.Fumetteria.web.command.AuthorCommand;
import school.devskill.Fumetteria.web.dto.list.ListAuthorDTO;
import school.devskill.Fumetteria.web.dto.single.AuthorDTO;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final IAuthorService autorService;
    private ObjectMapper mapper;

    @Autowired
    public AuthorController(IAuthorService autorService, ObjectMapper mapper) {
        this.autorService = autorService;
        this.mapper = mapper;
    }

    @PostMapping(value = HTTPUtility.CREATE)
    public AuthorDTO authorCreate(@RequestBody AuthorCommand command){
        Author nuovoAuthor = mapper.convertValue(command, Author.class);
        return mapper.convertValue(autorService.createAuthor(nuovoAuthor), AuthorDTO.class);
    };

    @GetMapping(value = HTTPUtility.GET)
    public List<AuthorDTO> listaAutori() {
        List<Author> autorsDalDb = autorService.getAuthors();
        List<AuthorDTO> ritorno = new ArrayList<>();
        for (int i = 0; i < autorsDalDb.size(); i++) {
            try {
                ritorno.add(mapper.convertValue(autorsDalDb.get(i), AuthorDTO.class));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return ritorno;
    }

    @GetMapping(value = HTTPUtility.LIST)
    public ListAuthorDTO listaAuthors() {
        List<Author> autorsDalDb = autorService.getAuthors();
        ListAuthorDTO ritorno = new ListAuthorDTO();
        for (int i = 0; i < autorsDalDb.size(); i++) {
            try {
                ritorno.getList().add(mapper.convertValue(autorsDalDb.get(i), AuthorDTO.class));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return ritorno;
    }

    @DeleteMapping(value = HTTPUtility.DELETE)
    public AuthorDTO authorDelete(@PathVariable Integer id){

        return mapper.convertValue(autorService.deleteAuthor(id), AuthorDTO.class);
    };

    @PutMapping(value = HTTPUtility.UPDATE)
    public AuthorDTO authorUpdate(@PathVariable("id") Integer id, @RequestBody AuthorCommand command){
        Author daModificare = mapper.convertValue(command, Author.class);
        daModificare.setId(id);
        return mapper.convertValue(autorService.updateAuthor(daModificare), AuthorDTO.class);
    };

    @GetMapping(value = HTTPUtility.GETBYID)
    public AuthorDTO authorgett(@PathVariable Integer id){

        return mapper.convertValue(autorService.getAuthor(id), AuthorDTO.class);
    };

}
