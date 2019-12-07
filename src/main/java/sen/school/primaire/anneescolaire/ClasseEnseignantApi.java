package sen.school.primaire.anneescolaire;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sen.school.primaire.enseignant.Enseignant;

@RestController
@Slf4j
public class ClasseEnseignantApi {

    @Autowired
    ClasseEnseignantRepositoryService classeEnseignantRepositoryService;

    @ApiOperation("affect class to teacher")
    @RequestMapping(value = "/classeenseignant", method = RequestMethod.POST)
    public ResponseEntity<ClasseEnseignant> openClass(@RequestBody ClasseEnseignant classeEnseignant) {

        return new ResponseEntity<>(
                classeEnseignantRepositoryService.save(classeEnseignant),
                HttpStatus.CREATED);

    }


    @ApiOperation(" find enseignant of a classe")
    @RequestMapping(value = "/classes/{idClasse}/annees/{idAnnee}/enseignant", method = RequestMethod.GET)
    public ResponseEntity<Enseignant> findEnseignantofClass(@PathVariable("idAnnee") int idAnnee, @PathVariable("idClasse") int idClasse) {

        return new ResponseEntity<>(
                classeEnseignantRepositoryService.findEnseignantByIdClasse(idAnnee, idClasse),
                HttpStatus.CREATED);

    }


}
