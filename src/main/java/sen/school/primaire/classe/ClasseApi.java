package sen.school.primaire.classe;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sen.school.primaire.annee.Annee;

import java.util.List;
import java.util.Optional;

@RestController(value = "/classes")
@Slf4j
public class ClasseApi {

    @Autowired
    ClasseApiService classeApiService;

    @ApiOperation((" find classe by id"))
    @RequestMapping(value = "/classes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Classe>> findById(@PathVariable(value = "id") Long id) {
        if (id == null)
            return new ResponseEntity<>(
                    classeApiService.findById(id),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(
                    classeApiService.findById(id),
                    HttpStatus.FOUND);
    }

    @ApiOperation((" find all classes"))
    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public ResponseEntity<List<Classe>> findAll() {
        return new ResponseEntity<>(
                classeApiService.findAll(),
                HttpStatus.OK);
    }

    @ApiOperation("create classe")
    @RequestMapping(value = "/classes", method = RequestMethod.POST)
    public ResponseEntity<Classe> save(@RequestBody Classe classe) {
        log.info("Create Classe [{}]" + classe);
        classeApiService.save(classe);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


}
