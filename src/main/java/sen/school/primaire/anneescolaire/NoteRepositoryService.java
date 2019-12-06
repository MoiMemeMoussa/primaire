package sen.school.primaire.anneescolaire;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class NoteRepositoryService {

    @Autowired
    NoteRepository noteRepository;

    Optional<Notes> findNotesById(NoteKey noteKey) {
        return noteRepository.findById(noteKey);
    }

    Notes saveNote(Notes notes) {
        return noteRepository.save(notes);
    }

    Notes findNoteEleveOneAnneeOneClasseOneMatiere(int idAnnee, int idClasse, int idMatiere, int idEleve) {
        return noteRepository.findNoteEleveOneAnneeOneClasseOneMatiere(idClasse, idAnnee, idEleve, idMatiere);
    }


}
