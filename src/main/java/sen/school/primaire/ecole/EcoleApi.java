package sen.school.primaire.ecole;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/ecoles")
@Slf4j
public class EcoleApi {

    @Autowired
    EcoleRepositoryService ecoleRepositoryService;

    @ApiOperation(" create ecole")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Ecole> save(@RequestBody Ecole ecole) {
        log.info("Create Ecole [{}]" + ecole);
        ecoleRepositoryService.save(ecole);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("find ecole by id")
    @RequestMapping(value = "/ecoles/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Ecole>> findById(
            @PathVariable(value = "id") Long id) {
        log.info("find ecole with id = [{}]", id);
        if (id == null){
            return new ResponseEntity<>(
                    ecoleRepositoryService.findById(id),
                    HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(
                    ecoleRepositoryService.findById(id),
                    HttpStatus.FOUND);
        }
    }

    @ApiOperation(("Retrieve all ecoles"))
    @RequestMapping(value = "/ecoles", method = RequestMethod.GET)
    public ResponseEntity<List<Ecole>> findAll() {
        log.info("Find all ecoles");
        return new ResponseEntity<>(
                ecoleRepositoryService.findAll(),
                HttpStatus.OK);
    }


    @ApiOperation(value = "Delete ecole")
    @RequestMapping(value = "/ecoles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClasse(@PathVariable(value = "id") Long id) {
        log.info("Delete ecole with id = [{}]", id);
        Optional<Ecole> ecole = ecoleRepositoryService.findById(id);
        if (ecole == null) {
            return new ResponseEntity("There is no ecole with ID " + id,
                    HttpStatus.NOT_FOUND);
        }
        ecoleRepositoryService.delete(ecole.get());
        return new ResponseEntity(ecole, HttpStatus.OK);
    }

}
