package school.devskill.Fumetteria.web.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.devskill.Fumetteria.model.Autor;
import school.devskill.Fumetteria.service.interfaces.IAutorService;
import school.devskill.Fumetteria.utility.HTTPUtility;
import school.devskill.Fumetteria.web.command.AutorCommand;
import school.devskill.Fumetteria.web.dto.AutorDTO;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private final IAutorService autorService;
    private ObjectMapper mapper;

    @Autowired
    public AutorController(IAutorService autorService, ObjectMapper mapper) {
        this.autorService = autorService;
        this.mapper = mapper;
    }

    @PostMapping(value = HTTPUtility.CREATE)
    public AutorDTO autorCreate(@RequestBody AutorCommand command){
        Autor nuovoAutor = mapper.convertValue(command,Autor.class);
        return mapper.convertValue(autorService.createAutor(nuovoAutor),AutorDTO.class);
    };

    @GetMapping(value = HTTPUtility.GET)
    public List<AutorDTO> listaAutori() {
        List<Autor> autorsDalDb = autorService.getAutors();
        List<AutorDTO> ritorno = new ArrayList<>();
        for (int i = 0; i < autorsDalDb.size(); i++) {
            try {
                ritorno.add(mapper.convertValue(autorsDalDb.get(i), AutorDTO.class));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return ritorno;
    }

    @DeleteMapping(value = HTTPUtility.DELETE)
    public AutorDTO autorDelete(@PathVariable Integer id){

        return mapper.convertValue(autorService.deleteAutor(id),AutorDTO.class);
    };

    @PutMapping(value = HTTPUtility.UPDATE)
    public AutorDTO autorUpdate(@PathVariable("id") Integer id, @RequestBody AutorCommand command){
        Autor daModificare = mapper.convertValue(command,Autor.class);
        daModificare.setId(id);
        return mapper.convertValue(autorService.updateAutor(daModificare), AutorDTO.class);
    };
}
