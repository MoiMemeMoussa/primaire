package sen.school.primaire.matiere;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class MatiereApi {

    @Autowired
    MatiereRepositoryService matiereRepositoryService;


    @ApiOperation(" create matiere")
    @RequestMapping(value = "/matieres", method = RequestMethod.POST)
    public ResponseEntity<Matiere> save(@RequestBody Matiere matiere) {
        log.info("Create MAtiere [{}]" + matiere);
        matiereRepositoryService.save(matiere);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @ApiOperation(value = "Retrieve all matieres")
    @RequestMapping(value = "/matieres", method = RequestMethod.GET)
    public List<Matiere> findAll() {
        log.info("Find all matieres");
        return matiereRepositoryService.findAll();
    }


    @ApiOperation(" find matiere by id")
    @RequestMapping(value = "/matieres/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Matiere>> find(@PathVariable(value = "id") Long id) {
        Optional<Matiere> matiere = matiereRepositoryService.findById(id);
        if(StringUtils.isEmpty(matiere)){
            return new ResponseEntity<>(matiere, HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(matiere, HttpStatus.FOUND);
        }
    }

    @ApiOperation(value = "Delete a matiere")
    @RequestMapping(value = "/matieres/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMatiere(@PathVariable(value = "id") Long id) {
        log.info("Delete matiere with id = [{}]", id);
        Optional<Matiere> matiere = matiereRepositoryService.findById(id);
        if (matiere == null) {
            return new ResponseEntity("There is no matiere with ID " + id,
                    HttpStatus.NOT_FOUND);
        }
        matiereRepositoryService.delete(matiere.get());
        return new ResponseEntity(matiere, HttpStatus.OK);
    }

}
