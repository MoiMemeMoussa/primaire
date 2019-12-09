package sen.school.primaire.trimestre;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class TrimestreApi {

    @Autowired
    TrimestreRepositoryService trimestreRepositoryService;

    @RequestMapping(value = "/trimestres/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        log.info("Delete trimestre  with id = [{}]", id);
        Optional<Trimestre> trimestre = trimestreRepositoryService.findById(id);
        if (trimestre == null){
            return new ResponseEntity("There is no trimestre with id " + trimestre,
                    HttpStatus.NOT_FOUND);
        }
        trimestreRepositoryService.delete(trimestre.get());
        return new ResponseEntity(trimestre, HttpStatus.OK);
    }

    @ApiOperation("Find  trimestre by id")
    @RequestMapping(value = "/trimestres/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Trimestre>> findById(
            @PathVariable(value = "id") Integer id) {
        if (id == null)
            return new ResponseEntity<>(
                    trimestreRepositoryService.findById(id),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(
                    trimestreRepositoryService.findById(id),
                    HttpStatus.FOUND);
    }

    @ApiOperation("Find all trimestre")
    @RequestMapping(value = "/trimestres", method = RequestMethod.GET)
    public ResponseEntity<List<Trimestre>> findAll(
    ) {
        return new ResponseEntity<>(
                trimestreRepositoryService.findAll(),
                HttpStatus.OK);

    }


    @ApiOperation("create trimestre")
    @RequestMapping(value = "/trimestres", method = RequestMethod.POST)
    public ResponseEntity<Trimestre> save(@RequestBody Trimestre trimestre) {

        return new ResponseEntity<>(
                trimestreRepositoryService.save(trimestre),
                HttpStatus.CREATED);

    }
}
