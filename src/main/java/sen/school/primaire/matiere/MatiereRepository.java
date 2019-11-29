package sen.school.primaire.matiere;

import org.springframework.data.jpa.repository.JpaRepository;
import sen.school.primaire.enseignant.Enseignant;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {


}
