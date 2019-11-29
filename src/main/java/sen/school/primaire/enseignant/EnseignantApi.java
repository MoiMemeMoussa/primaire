package sen.school.primaire.enseignant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ecoles")
@Slf4j
public class EnseignantApi {

    @Autowired
    EnseignantApiService enseignantApiService;

    @RequestMapping(value = "/{matricule}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Enseignant>> findById(
            @PathVariable(value = "matricule") String matricule) {
        if (matricule == null)
            return new ResponseEntity<Optional<Enseignant>>(
                    enseignantApiService.findById(matricule),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Optional<Enseignant>>(
                    enseignantApiService.findById(matricule),
                    HttpStatus.FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Enseignant>> findAll(
    ) {
        return new ResponseEntity<>(
                enseignantApiService.findAll(),
                HttpStatus.OK);

    }


}
