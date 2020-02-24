package sen.school.primaire.anneescolaire;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sen.school.primaire.eleve.Eleve;

import java.util.List;

@RestController
@Slf4j
public class ClasseEleveApi {

    @Autowired
    ClasseEleveRepositoryService classeEleveRepositoryService;

    @ApiOperation("add eleve to classe")
    @RequestMapping(value = "/classeseleves", method = RequestMethod.POST)
    public ResponseEntity<ClasseEleve> insertEleveToClass(@RequestBody ClasseEleve classeEleve) {

        return new ResponseEntity<>(
                classeEleveRepositoryService.save(classeEleve),
                HttpStatus.CREATED);
    }

    @ApiOperation(" find liste eleves  of a classe in a year ")
    @RequestMapping(value = "/classeseleves/{idAnnee}/{idClasse}", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> findListeELeveByIdClasseAndAnnee(@PathVariable("idAnnee") int idAnnee, @PathVariable("idClasse") int idClasse) {

        return new ResponseEntity<>(
                classeEleveRepositoryService.findListeELeveByIdClasseAndAnnee(idAnnee, idClasse),
                HttpStatus.CREATED);
    }

    @ApiOperation(" delete eleve from class ")
    @RequestMapping(value = "/classeseleves/{idAnnee}/{idClasse}/{idEleve}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEleveFromClasse(@PathVariable("idAnnee") int idAnnee, @PathVariable("idClasse") int idClasse, @PathVariable("idClasse") int idEleve) {
        ClasseEleve classeEleve = classeEleveRepositoryService.findELeveByIdClasseAndAnnee(idClasse, idAnnee, idEleve);
        classeEleveRepositoryService.deleteEleveFromClasse(classeEleve);
        return new ResponseEntity(classeEleve, HttpStatus.OK);

    }

    @ApiOperation(" Find all boys in one class, in one school year")
    @RequestMapping(value = "/classes/{idClasse}/annees/{idAnnee}/garcons", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> findBoys(@PathVariable("idAnnee") int idAnnee,
                                                @PathVariable("idClasse") int idClasse) {
        return new ResponseEntity(classeEleveRepositoryService.findBoys(idAnnee, idClasse), HttpStatus.OK);
    }

    @ApiOperation(" Find all girls in one class, in one school year")
    @RequestMapping(value = "/classes/{idClasse}/annees/{idAnnee}/filles", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> findGirls(@PathVariable("idAnnee") int idAnnee,
                                                 @PathVariable("idClasse") int idClasse) {
        return new ResponseEntity(classeEleveRepositoryService.findGirls(idAnnee, idClasse), HttpStatus.OK);
    }

}
