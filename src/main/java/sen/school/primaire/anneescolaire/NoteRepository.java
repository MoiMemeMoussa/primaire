package sen.school.primaire.anneescolaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoteRepository extends JpaRepository<Notes, NoteKey> {

    @Query("from Eleve E,Notes N WHERE E.idEleve = N.noteKey.idEleve AND E.idEleve=:idEleve AND N.noteKey.idAnnee =:idAnnee AND N.noteKey.idClasse=:idClasse AND N.noteKey.idMatiere=:idMatiere ")
    Notes findNoteEleveOneAnneeOneClasseOneMatiere(@Param("idClasse") int idClasse, @Param("idAnnee") int idAnnee, @Param("idEleve") int idEleve, @Param("idMatiere") int idMatiere);


}
