package sen.school.primaire.eleve;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@Slf4j
public class EleveApi {

    @Autowired
    EleveRepositoryService eleveRepositoryService;

    @RequestMapping(value = "/eleves/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        log.info("Delete eleve  with id = [{}]", id);
        Optional<Eleve> eleve = eleveRepositoryService.findById(id);
        if (eleve == null){
            return new ResponseEntity("There is no annee with ID " + id,
                    HttpStatus.NOT_FOUND);
        }
        eleveRepositoryService.delete(eleve.get());
        return new ResponseEntity(eleve, HttpStatus.OK);
    }

    @RequestMapping(value = "/eleves/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Eleve>> findById(
            @PathVariable(value = "id") Integer id) {
        if (id == null)
            return new ResponseEntity<>(
                    eleveRepositoryService.findById(id),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(
                    eleveRepositoryService.findById(id),
                    HttpStatus.FOUND);
    }


    @RequestMapping(value = "/eleves", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> findAll() {
        return new ResponseEntity<>(
                eleveRepositoryService.findAll(),
                HttpStatus.OK);
    }


    @ApiOperation("create eleve")
    @RequestMapping(value = "/eleves", method = RequestMethod.POST)
    public ResponseEntity<Eleve> save(@RequestBody Eleve eleve) {

        return new ResponseEntity<>(
                eleveRepositoryService.save(eleve),
                HttpStatus.CREATED);

    }
}
