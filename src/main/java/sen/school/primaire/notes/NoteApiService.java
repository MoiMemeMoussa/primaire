package sen.school.primaire.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sen.school.primaire.matiere.Matiere;

import java.util.List;
import java.util.Optional;

@Component
public class NoteApiService {

    @Autowired
    NoteRepositoryService noteRepositoryService;


    public Note save(Note note) {
        return noteRepositoryService.save(note);
    }


}
