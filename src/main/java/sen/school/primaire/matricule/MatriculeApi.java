package sen.school.primaire.matricule;

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
public class MatriculeApi {

    @Autowired
    MatriculeRepositoryService MatriculeRepositoryService;


    @ApiOperation(" create Matricule")
    @RequestMapping(value = "/Matricules", method = RequestMethod.POST)
    public ResponseEntity<Matricule> save(@RequestBody Matricule Matricule) {
        log.info("Create Matricule [{}]" + Matricule);
        MatriculeRepositoryService.save(Matricule);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @ApiOperation(value = "Retrieve all Matricules")
    @RequestMapping(value = "/Matricules", method = RequestMethod.GET)
    public List<Matricule> findAll() {
        log.info("Find all Matricules");
        return MatriculeRepositoryService.findAll();
    }


    @ApiOperation(" find Matricule by id")
    @RequestMapping(value = "/Matricules/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Matricule>> find(@PathVariable(value = "id") Integer id) {
        Optional<Matricule> Matricule = MatriculeRepositoryService.findById(id);
        if (StringUtils.isEmpty(Matricule)){
            return new ResponseEntity<>(Matricule, HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(Matricule, HttpStatus.FOUND);
        }
    }

    @ApiOperation(value = "Delete a Matricule")
    @RequestMapping(value = "/Matricules/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMatricule(@PathVariable(value = "id") Integer id) {
        log.info("Delete Matricule with id = [{}]", id);
        Optional<Matricule> Matricule = MatriculeRepositoryService.findById(id);
        if (Matricule == null){
            return new ResponseEntity("There is no Matricule with ID " + id,
                    HttpStatus.NOT_FOUND);
        }
        MatriculeRepositoryService.delete(Matricule.get());
        return new ResponseEntity(Matricule, HttpStatus.OK);
    }

}
