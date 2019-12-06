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

    @ApiOperation(" find liste matiere  of a classe in a year ")
    @RequestMapping(value = "/classematiere/{idAnnee}/{idClasse}", method = RequestMethod.GET)
    public ResponseEntity<List<Matiere>> findEnseignantofClass(@Param("idAnnee") int idAnnee, @Param("idClasse") int idClasse) {

        return new ResponseEntity<>(
                classeMatiereRepositoryService.findListeMatiereByIdClasseAndAnnee(idAnnee, idClasse),
                HttpStatus.CREATED);

    }

}
