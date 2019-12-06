package sen.school.primaire.anneescolaire;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
public class NoteApi {

    @Autowired
    NoteRepositoryService noteRepositoryService;

    @ApiOperation("saving note ")
    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public ResponseEntity<Notes> saveNote(@RequestBody Notes notes) {

        return new ResponseEntity<>(
                noteRepositoryService.saveNote(notes),
                HttpStatus.CREATED);
    }

    @ApiOperation("finding note by id ")
    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Notes>> findNotesById(@RequestBody NoteKey noteKey) {

        return new ResponseEntity<>(
                noteRepositoryService.findNotesById(noteKey),
                HttpStatus.FOUND);
    }

    @ApiOperation(" Find note student, for a year, one class,one subject ")
    @RequestMapping(value = "/notes/?annee={idAnnee}&classe={idClasse}&matiere={idMatiere}&idEleve={idEleve}", method = RequestMethod.GET)
    public ResponseEntity<Notes> findNotesById(
            @PathVariable("idAnnee") Integer idAnnee,
            @PathVariable("idClasse") Integer idClasse,
            @PathVariable("idMatiere") Integer idMatiere,
            @PathVariable("idEleve") Integer idEleve) {

        return new ResponseEntity<>(
                noteRepositoryService.findNoteEleveOneAnneeOneClasseOneMatiere(idAnnee, idClasse, idMatiere, idEleve),
                HttpStatus.FOUND);
    }


}
