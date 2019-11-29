package sen.school.primaire.classe;

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
@RequestMapping(value = "/classes")
@Slf4j
public class ClasseApi {

    @Autowired
    ClasseApiService classeApiService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Classe>> findById(
            @PathVariable(value = "id") Long id) {
        if (id == null)
            return new ResponseEntity<>(
                    classeApiService.findById(id),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(
                    classeApiService.findById(id),
                    HttpStatus.FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Classe>> findAll(
    ) {
        return new ResponseEntity<>(
                classeApiService.findAll(),
                HttpStatus.OK);

    }


}
