package sen.school.primaire.enseignant;

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
public class EnseignantApi {

    @Autowired
    EnseignantRepositoryService enseignantRepositoryService;

    @RequestMapping(value = "/enseignants/{matricule}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "matricule") String matricule) {
        log.info("Delete enseignant  with matricule = [{}]", matricule);
        Optional<Enseignant> enseignant = enseignantRepositoryService.findById(matricule);
        if (enseignant == null){
            return new ResponseEntity("There is no enseignant with MATRICULE " + matricule,
                    HttpStatus.NOT_FOUND);
        }
        enseignantRepositoryService.delete(enseignant.get());
        return new ResponseEntity(enseignant, HttpStatus.OK);
    }

    @ApiOperation("Find  enseignant by matricule")
    @RequestMapping(value = "/enseignants/{matricule}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Enseignant>> findById(
            @PathVariable(value = "matricule") String matricule) {
        if (matricule == null)
            return new ResponseEntity<>(
                    enseignantRepositoryService.findById(matricule),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(
                    enseignantRepositoryService.findById(matricule),
                    HttpStatus.FOUND);
    }

    @ApiOperation("Find all enseignants")
    @RequestMapping(value = "/enseignants", method = RequestMethod.GET)
    public ResponseEntity<List<Enseignant>> findAll(
    ) {
        return new ResponseEntity<>(
                enseignantRepositoryService.findAll(),
                HttpStatus.OK);

    }

    @ApiOperation("create enseignant")
    @RequestMapping(value = "/enseignants", method = RequestMethod.POST)
    public ResponseEntity<Enseignant> save(@RequestBody Enseignant enseignant) {

        return new ResponseEntity<>(
                enseignantRepositoryService.save(enseignant),
                HttpStatus.CREATED);

    }
}
