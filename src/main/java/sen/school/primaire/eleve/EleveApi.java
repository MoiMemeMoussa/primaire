package sen.school.primaire.eleve;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/eleves")
@Slf4j
public class EleveApi {

    @Autowired
    EleveApiService eleveApiService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Eleve>> findById(
            @PathVariable(value = "id") String id) {
        if (id == null)
            return new ResponseEntity<>(
                    eleveApiService.findById(Integer.parseInt(id)),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(
                    eleveApiService.findById(Integer.parseInt(id)),
                    HttpStatus.FOUND);
    }


}
