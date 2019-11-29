package sen.school.primaire.ecole;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sen.school.primaire.annee.Annee;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ecoles")
@Slf4j
public class EcoleApi {

    @Autowired
    EcoleApiService ecoleApiService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Ecole>> findById(
            @PathVariable(value = "id") String id) {
        if (id == null)
            return new ResponseEntity<>(
                    ecoleApiService.findById(Integer.parseInt(id)),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(
                    ecoleApiService.findById(Integer.parseInt(id)),
                    HttpStatus.FOUND);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Ecole>> findAll(
    ) {
        return new ResponseEntity<>(
                ecoleApiService.findAll(),
                HttpStatus.OK);

    }


}
