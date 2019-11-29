package sen.school.primaire.anneeecoleclasse;

import org.springframework.data.jpa.repository.JpaRepository;
import sen.school.primaire.annee.Annee;
import sen.school.primaire.classe.Classe;

import java.util.List;

public interface AnneeEcoleClasseRepository extends JpaRepository<AnneeEcoleClasse, AnneeEcoleClasseKey> {


}
