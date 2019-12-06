package sen.school.primaire.anneescolaire;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sen.school.primaire.matiere.Matiere;

import java.util.List;

@Slf4j
@Component
public class ClasseMatiereRepositoryService {

    @Autowired
    ClasseMatiereRepository classeMatiereRepository;

    //affecter une classe à un enseigant
    ClasseMatiere save(ClasseMatiere classeMatiere) {
        return classeMatiereRepository.save(classeMatiere);
    }

    List<Matiere> findListeMatiereByIdClasseAndAnnee(int idClasse, int idAnnee) {
        return classeMatiereRepository.findListeMatiereByIdClasseAndAnnee(idClasse, idAnnee);
    }


}
