package sen.school.primaire.anneescolaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sen.school.primaire.enseignant.Enseignant;

public interface ClasseEnseignantRepository extends JpaRepository<ClasseEnseignant, ClasseEnseignantKey> {

    @Query("from ClasseEnseignant CE where CE.classeEnseignantKey.idAnnee = :idAnnee AND CE.classeEnseignantKey.idClasse=:idClasse ")
    Enseignant findEnseignantByIdClasse(@Param("idAnnee") int idAnnee, @Param("idClasse") int idClasse);
}
