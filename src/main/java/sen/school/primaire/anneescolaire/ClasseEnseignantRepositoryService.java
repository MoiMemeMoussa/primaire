package sen.school.primaire.anneescolaire;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sen.school.primaire.enseignant.Enseignant;

@Slf4j
@Component
public class ClasseEnseignantRepositoryService {

    @Autowired
    ClasseEnseignantRepository classeEnseignantRepository;

    //affecter une classe à un enseigant
    ClasseEnseignant save(ClasseEnseignant classeEnseignant) {
        return classeEnseignantRepository.save(classeEnseignant);
    }

    Enseignant findEnseignantByIdClasse(int idAnnee, int idClasse) {
        return classeEnseignantRepository.findEnseignantByIdClasse(idAnnee, idClasse);
    }


}
