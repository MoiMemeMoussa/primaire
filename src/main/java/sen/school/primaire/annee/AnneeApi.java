package sen.school.primaire.annee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sen.school.primaire.matiere.Matiere;

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

    //Save new annee scolaire
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Annee> save(@RequestParam(value = "value") String value) {
        Annee annee = new Annee();
        if(!StringUtils.isEmpty(value)){
            annee.setValue(value);
        }
        return new ResponseEntity<>(
                anneeApiService.save(annee),
                HttpStatus.CREATED);

    }


}
