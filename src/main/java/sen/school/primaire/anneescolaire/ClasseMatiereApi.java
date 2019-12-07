package sen.school.primaire.anneescolaire;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sen.school.primaire.matiere.Matiere;

import java.util.List;

@RestController
@Slf4j
public class ClasseMatiereApi {

    @Autowired
    ClasseMatiereRepositoryService classeMatiereRepositoryService;

    @ApiOperation("add matiere to classe")
    @RequestMapping(value = "/classematiere", method = RequestMethod.POST)
    public ResponseEntity<ClasseMatiere> openClass(@RequestBody ClasseMatiere classeMatiere) {

        return new ResponseEntity<>(
                classeMatiereRepositoryService.save(classeMatiere),
                HttpStatus.CREATED);

    }

    @ApiOperation(" find list subjet  of a classe in a year ")
    @RequestMapping(value = "/classes/{idClasse}/annees/{idAnnee}/matieres", method = RequestMethod.GET)
    public ResponseEntity<List<Matiere>> findEnseignantofClass(@PathVariable("idAnnee") int idAnnee,
                                                               @PathVariable("idClasse") int idClasse) {

        return new ResponseEntity<>(
                classeMatiereRepositoryService.findListeMatiereByIdClasseAndAnnee(idAnnee, idClasse),
                HttpStatus.CREATED);

    }

}
