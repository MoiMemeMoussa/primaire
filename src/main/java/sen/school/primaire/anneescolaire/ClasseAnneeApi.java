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
    @RequestMapping(value = "/classeannee/{idAnnee}", method = RequestMethod.GET)
    public ResponseEntity<List<Classe>> openClass(@Param("idAnnee") int idAnnee) {

        return new ResponseEntity<>(
                classeAnneeRepositoryService.findAllClasseOpenedByYear(idAnnee),
                HttpStatus.CREATED);

    }

}
