package sen.school.primaire.notes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NoteRepositoryService {

    @Autowired
    NoteRepository noteRepository;

    Note save(Note note) {
        return noteRepository.save(note);
    }


}
