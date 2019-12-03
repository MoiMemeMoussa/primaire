package sen.school.primaire.anneeecole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sen.school.primaire.annee.Annee;
import sen.school.primaire.classe.Classe;
import sen.school.primaire.ecole.Ecole;

import java.util.List;

public interface AnneeEcoleRepository extends JpaRepository<AnneeEcole, AnneeEcoleKey> {


}
