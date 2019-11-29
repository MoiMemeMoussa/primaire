package sen.school.primaire.inscription;

import org.springframework.data.jpa.repository.JpaRepository;
import sen.school.primaire.anneeecoleclasse.AnneeEcoleClasse;
import sen.school.primaire.anneeecoleclasse.AnneeEcoleClasseKey;

public interface InscriptionRepository extends JpaRepository<Inscription, InscriptionKey> {


}
