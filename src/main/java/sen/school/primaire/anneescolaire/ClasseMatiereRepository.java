package sen.school.primaire.anneescolaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sen.school.primaire.matiere.Matiere;

import java.util.List;

public interface ClasseMatiereRepository extends JpaRepository<ClasseMatiere, ClasseMatiereKey> {


    @Query("from Matiere M,ClasseMatiere CM where CM.classeMatiereKey.idAnnee = :idAnnee AND CM.classeMatiereKey.idClasse=:idClasse AND CM.classeMatiereKey.idMatiere=M.idMatiere ")
    List<Matiere> findListeMatiereByIdClasseAndAnnee(int idClasse, int idAnnee);

}
