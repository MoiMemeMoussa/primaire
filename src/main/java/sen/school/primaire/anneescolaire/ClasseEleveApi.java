package sen.school.primaire.anneescolaire;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    @RequestMapping(value = "/classeeleve", method = RequestMethod.POST)
    public ResponseEntity<ClasseEleve> insertEleveToClass(@RequestBody ClasseEleve classeEleve) {

        return new ResponseEntity<>(
                classeEleveRepositoryService.save(classeEleve),
                HttpStatus.CREATED);
    }

    @ApiOperation(" find liste eleves  of a classe in a year ")
    @RequestMapping(value = "/classeeleve/{idAnnee}/{idClasse}", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> findListeELeveByIdClasseAndAnnee(@Param("idAnnee") int idAnnee, @Param("idClasse") int idClasse) {

        return new ResponseEntity<>(
                classeEleveRepositoryService.findListeELeveByIdClasseAndAnnee(idAnnee, idClasse),
                HttpStatus.CREATED);
    }

    @ApiOperation(" find liste eleves  of a classe with status P in a year ")
    @RequestMapping(value = "/classeeleve/{idAnnee}/{idClasse}?status=P", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> findListeELevePassantsByIdClasseAndAnnee(@Param("idAnnee") int idAnnee, @Param("idClasse") int idClasse) {
        return new ResponseEntity<>(
                classeEleveRepositoryService.findListeELevePassantsByIdClasseAndAnnee(idAnnee, idClasse),
                HttpStatus.CREATED);
    }

    @ApiOperation(" find liste eleves  of a classe with status R in a year ")
    @RequestMapping(value = "/classeeleve/{idAnnee}/{idClasse}?status=R", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> findListeELeveRedoublantsByIdClasseAndAnnee(@Param("idAnnee") int idAnnee, @Param("idClasse") int idClasse) {

        return new ResponseEntity<>(
                classeEleveRepositoryService.findListeELeveRedoublantsByIdClasseAndAnnee(idAnnee, idClasse),
                HttpStatus.CREATED);
    }

    @ApiOperation(" find liste eleves  class with gender equals to M  ")
    @RequestMapping(value = "/classeeleve/{idAnnee}/{idClasse}?gender=M", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> findListeELeveWithGenderEqualsToM(@Param("idAnnee") int idAnnee, @Param("idClasse") int idClasse) {

        return new ResponseEntity<>(
                classeEleveRepositoryService.findListeELeveWithGenderEqualsToM(idAnnee, idClasse),
                HttpStatus.CREATED);
    }

    @ApiOperation(" find liste eleves  class with gender equals to M  ")
    @RequestMapping(value = "/classeeleve/{idAnnee}/{idClasse}?gender=F", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> findListeELeveWithGenderEqualsToF(@Param("idAnnee") int idAnnee, @Param("idClasse") int idClasse) {

        return new ResponseEntity<>(
                classeEleveRepositoryService.findListeELeveWithGenderEqualsToF(idAnnee, idClasse),
                HttpStatus.CREATED);
    }

    @ApiOperation(" delete eleve from class ")
    @RequestMapping(value = "/classeeleve/{idAnnee}/{idClasse}/{idEleve}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEleveFromClasse(@PathVariable("idAnnee") int idAnnee, @PathVariable("idClasse") int idClasse, @PathVariable("idClasse") int idEleve) {
        ClasseEleve classeEleve = classeEleveRepositoryService.findELeveByIdClasseAndAnnee(idClasse, idAnnee, idEleve);
        classeEleveRepositoryService.deleteEleveFromClasse(classeEleve);
        return new ResponseEntity(classeEleve, HttpStatus.OK);

    }

}
