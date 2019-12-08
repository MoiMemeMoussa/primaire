package sen.school.primaire.anneescolaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sen.school.primaire.classe.Classe;

import java.util.List;

public interface ClasseAnneeRepository extends JpaRepository<ClasseAnnee, ClasseAnneeKey> {


    @Query(value = "select C from Classe C, ClasseAnnee CA, Annee A WHERE A.idAnnee =:idAnnee AND A.idAnnee=CA.classeAnneeKey.idAnnee AND C.idClasse=CA.classeAnneeKey.idClasse")
    List<Classe> findAllClasseLinkedToAYear(int idAnnee);
}
