package sen.school.primaire.matiere;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/matiere")
@Slf4j
public class MatiereApi {

    @Autowired
    MatiereApiService matiereApiService;


    //Save new matiere
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Matiere> save(  @RequestParam(value = "name") String name) {
        Matiere matiere = new Matiere();
        if(!StringUtils.isEmpty(name)){
            matiere.setName(name);
        }
        return new ResponseEntity<>(
                matiereApiService.save(matiere),
                HttpStatus.CREATED);

    }

    //Get matiere by id
    @RequestMapping(value = "/{idMatiere}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Matiere>> findById(
            @PathVariable(value = "idMatiere") Long idMatiere) {
        if (idMatiere == null)
            return new ResponseEntity<Optional<Matiere>>(
                    matiereApiService.findById(idMatiere),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Optional<Matiere>>(
                    matiereApiService.findById(idMatiere),
                    HttpStatus.FOUND);
    }

    //Get all matiere
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Matiere>> findAll(
    ) {
        return new ResponseEntity<>(
                matiereApiService.findAll(),
                HttpStatus.OK);

    }


}
