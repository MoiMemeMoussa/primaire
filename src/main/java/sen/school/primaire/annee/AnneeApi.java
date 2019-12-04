package sen.school.primaire.annee;

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
public class AnneeApi {

    @Autowired
    AnneeRepositoryService anneeRepositoryService;

    @ApiOperation("Find annee by id")
    @RequestMapping(value = "/annee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Annee>> findById(
            @PathVariable(value = "id") Integer id) {
        if (id == null){
            return new ResponseEntity<>(
                    anneeRepositoryService.findById(id),
                    HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(
                    anneeRepositoryService.findById(id),
                    HttpStatus.FOUND);
        }
    }

    @ApiOperation("Find all annee")
    @RequestMapping(value = "/annees", method = RequestMethod.GET)
    public ResponseEntity<List<Annee>> findAll(
    ) {
        return new ResponseEntity<>(
                anneeRepositoryService.findAll(),
                HttpStatus.OK);

    }

    @ApiOperation("create annee")
    @RequestMapping(value = "/annee", method = RequestMethod.POST)
    public ResponseEntity<Annee> save(@RequestParam(value = "value") String value) {
        Annee annee = new Annee();
        if (!StringUtils.isEmpty(value)){
            annee.setValue(value);
        }
        return new ResponseEntity<>(
                anneeRepositoryService.save(annee),
                HttpStatus.CREATED);

    }

    @ApiOperation(value = "Delete annee")
    @RequestMapping(value = "/annee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAnnee(@PathVariable(value = "id") Integer id) {
        log.info("Delete annee with id = [{}]", id);
        Optional<Annee> annee = anneeRepositoryService.findById(id);
        if (annee == null){
            return new ResponseEntity("There is no annee with ID " + id,
                    HttpStatus.NOT_FOUND);
        }
        anneeRepositoryService.delete(annee.get());
        return new ResponseEntity(annee, HttpStatus.OK);
    }


}
