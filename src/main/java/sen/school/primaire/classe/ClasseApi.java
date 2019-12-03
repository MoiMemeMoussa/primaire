package sen.school.primaire.classe;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sen.school.primaire.annee.Annee;

import java.util.List;
import java.util.Optional;

@RestController(value = "/classes")
@Slf4j
public class ClasseApi {

    @Autowired
    ClasseRepositoryService classeRepositoryService;

    @ApiOperation("create classe")
    @RequestMapping(value = "/classe", method = RequestMethod.POST)
    public ResponseEntity<Classe> save(@RequestBody Classe classe) {
        log.info("Create Classe [{}]" + classe);
        classeRepositoryService.save(classe);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @ApiOperation((" find classe by id"))
    @RequestMapping(value = "/classes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Classe>> findById(@PathVariable(value = "id") Long id) {
        log.info("Find  classe  with id = [{}]", id);
        if (id == null)
            return new ResponseEntity<>(
                    classeRepositoryService.findById(id),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(
                    classeRepositoryService.findById(id),
                    HttpStatus.FOUND);
    }

    @ApiOperation((" find all classes"))
    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public ResponseEntity<List<Classe>> findAll() {
        log.info("Find all classes");
        return new ResponseEntity<>(
                classeRepositoryService.findAll(),
                HttpStatus.OK);
    }

    @ApiOperation(value = "Delete classe")
    @RequestMapping(value = "/classe/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClasse(@PathVariable(value = "id") Long id) {
        log.info("Delete annee with id = [{}]", id);
        Optional<Classe> classe = classeRepositoryService.findById(id);
        if (classe == null) {
            return new ResponseEntity("There is no classe with ID " + id,
                    HttpStatus.NOT_FOUND);
        }
        classeRepositoryService.delete(classe.get());
        return new ResponseEntity(classe, HttpStatus.OK);
    }




}
