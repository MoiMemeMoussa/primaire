package sen.school.primaire.anneescolaire;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sen.school.primaire.classe.Classe;

import java.util.List;

@RestController
@Slf4j
public class ClasseAnneeApi {

    @Autowired
    ClasseAnneeRepositoryService classeAnneeRepositoryService;

    @ApiOperation("open new class for the school  year")
    @RequestMapping(value = "/classeannee", method = RequestMethod.POST)
    public ResponseEntity<ClasseAnnee> openClass(@RequestBody ClasseAnnee classeAnnee) {

        return new ResponseEntity<>(
                classeAnneeRepositoryService.save(classeAnnee),
                HttpStatus.CREATED);

    }

    @ApiOperation(" Find all class opened in a school year")
    @RequestMapping(value = "/annees/{idAnnee}/classes", method = RequestMethod.GET)
    public ResponseEntity<List<Classe>> findAllClasseLinkedToAYear(@PathVariable(value = "idAnnee") Integer idAnnee) {

        return new ResponseEntity<>(
                classeAnneeRepositoryService.findAllClasseLinkedToAYear(idAnnee),
                HttpStatus.CREATED);

    }

}
