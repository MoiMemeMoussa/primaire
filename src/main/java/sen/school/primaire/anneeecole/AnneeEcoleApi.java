package sen.school.primaire.anneeecole;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sen.school.primaire.annee.Annee;
import sen.school.primaire.classe.Classe;
import sen.school.primaire.ecole.Ecole;

import java.util.List;

@RestController
@Slf4j
public class AnneeEcoleApi {

    @Autowired
    AnneeEcoleRepositoryService anneeEcoleRepositoryService;

    @ApiOperation("create classe")
    @RequestMapping(value = "/anneeecole", method = RequestMethod.POST)
    public ResponseEntity<Classe> save(@RequestBody AnneeEcole anneeEcole) {
        log.info("Create AnneeEcole [{}]" + anneeEcole);
        anneeEcoleRepositoryService.save(anneeEcole);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
