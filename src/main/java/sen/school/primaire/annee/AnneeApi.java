package sen.school.primaire.annee;

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
@RequestMapping(value = "/annee")
@Slf4j
public class AnneeApi {

    @Autowired
    AnneeApiService anneeApiService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Annee>> findById(
            @PathVariable(value = "id") String id) {
        if (id == null)
            return new ResponseEntity<>(
                    anneeApiService.findById(Integer.parseInt(id)),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(
                    anneeApiService.findById(Integer.parseInt(id)),
                    HttpStatus.FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Annee>> findAll(
    ) {
        return new ResponseEntity<>(
                anneeApiService.findAll(),
                HttpStatus.OK);

    }


}
