package sen.school.primaire.ecole;

import org.springframework.data.jpa.repository.JpaRepository;
import sen.school.primaire.annee.Annee;

public interface EcoleRepository extends JpaRepository<Ecole, Integer> {


}
