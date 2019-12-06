package sen.school.primaire.anneescolaire;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sen.school.primaire.classe.Classe;

import java.util.List;

@Slf4j
@Component
public class ClasseAnneeRepositoryService {

    @Autowired
    ClasseAnneeRepository classeAnneeRepository;

    //ouvrir une classe dans une annee scolaire
    ClasseAnnee save(ClasseAnnee classeAnnee) {
        return classeAnneeRepository.save(classeAnnee);
    }

    List<Classe> findAllClasseOpenedByYear(int idAnnee) {
        return classeAnneeRepository.findAllClasseOpenedByYear(idAnnee);
    }

}
