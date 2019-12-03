package sen.school.primaire.notes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notes")
@Slf4j
public class NoteApi {

    @Autowired
    NoteRepositoryService noteRepositoryService;

    //Save new matiere
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Note> save(@PathVariable Note note) {
        return new ResponseEntity<>(
                noteRepositoryService.save(note),
                HttpStatus.CREATED);

    }


}
