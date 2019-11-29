package sen.school.primaire.notes;

import org.springframework.data.jpa.repository.JpaRepository;
import sen.school.primaire.matiere.Matiere;

public interface NoteRepository extends JpaRepository<Note, NoteKey> {


}
