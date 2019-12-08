package sen.school.primaire.anneescolaire;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sen.school.primaire.eleve.Eleve;

import java.util.List;

@Slf4j
@Component
public class ClasseEleveRepositoryService {

    @Autowired
    ClasseEleveRepository classeEleveRepository;

    ClasseEleve save(ClasseEleve classeEleve) {
        return classeEleveRepository.save(classeEleve);
    }

    List<Eleve> findListeELeveByIdClasseAndAnnee(int idAnnee, int idClasse) {
        return classeEleveRepository.findListeELeveByIdClasseAndAnnee(idClasse, idAnnee);
    }

    ClasseEleve findELeveByIdClasseAndAnnee(int idAnnee, int idClasse, int idEleve) {
        return classeEleveRepository.findEleveByClasse(idAnnee, idClasse, idEleve);
    }

    List<Eleve> findBoys(int idAnnee, int idClasse) {
        return classeEleveRepository.findAllBoys(idAnnee, idClasse);
    }

    List<Eleve> findGirls(int idAnnee, int idClasse) {
        return classeEleveRepository.findAllGilrs(idAnnee, idClasse);
    }
    void deleteEleveFromClasse(ClasseEleve classeEleve) {
        classeEleveRepository.delete(classeEleve);
    }


}
