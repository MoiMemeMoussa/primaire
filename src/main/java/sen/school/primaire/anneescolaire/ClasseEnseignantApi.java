package sen.school.primaire.anneescolaire;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    @RequestMapping(value = "/classeenseignant/{idAnnee}/{idClasse}", method = RequestMethod.GET)
    public ResponseEntity<Enseignant> findEnseignantofClass(@Param("idAnnee") int idAnnee, @Param("idClasse") int idClasse) {

        return new ResponseEntity<>(
                classeEnseignantRepositoryService.findEnseignantByIdClasse(idAnnee, idClasse),
                HttpStatus.CREATED);

    }


}
