package sen.school.primaire.anneescolaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sen.school.primaire.matiere.Matiere;

import java.util.List;

public interface ClasseMatiereRepository extends JpaRepository<ClasseMatiere, ClasseMatiereKey> {

    @Query("from ClasseMatiere CM where CM.classeMatiereKey.idAnnee = :idAnnee AND CM.classeMatiereKey.idClasse=:idClasse ")
    List<Matiere> findListeMatiereByIdClasseAndAnnee(@Param("idClasse") int idClasse, @Param("idAnnee") int idAnnee);

}
