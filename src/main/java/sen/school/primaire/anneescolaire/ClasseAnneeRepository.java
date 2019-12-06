package sen.school.primaire.anneescolaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sen.school.primaire.classe.Classe;

import java.util.List;

public interface ClasseAnneeRepository extends JpaRepository<ClasseAnnee, ClasseAnneeKey> {

    @Query("from ClasseAnnee CA where CA.classeAnneeKey.idAnnee = :idAnnee ")
    List<Classe> findAllClasseOpenedByYear(@Param("idAnnee") int idAnnee);
}
