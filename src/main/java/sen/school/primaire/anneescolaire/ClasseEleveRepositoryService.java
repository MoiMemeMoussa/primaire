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

    List<Eleve> findListeELeveByIdClasseAndAnnee(int idClasse, int idAnnee) {
        return classeEleveRepository.findListeELeveByIdClasseAndAnnee(idClasse, idAnnee);
    }

    ClasseEleve findELeveByIdClasseAndAnnee(int idClasse, int idAnnee, int idEleve) {
        return classeEleveRepository.findELeveByIdClasseAndAnnee(idClasse, idAnnee, idEleve);
    }

    List<Eleve> findListeELevePassantsByIdClasseAndAnnee(int idClasse, int idAnnee) {
        return classeEleveRepository.findListeELevePassantsByIdClasseAndAnnee(idClasse, idAnnee);
    }

    List<Eleve> findListeELeveRedoublantsByIdClasseAndAnnee(int idClasse, int idAnnee) {
        return classeEleveRepository.findListeELeveRedoublantsByIdClasseAndAnnee(idClasse, idAnnee);
    }

    List<Eleve> findListeELeveWithGenderEqualsToM(int idClasse, int idAnnee) {
        return classeEleveRepository.findListeELeveWithGenderEqualsToM(idClasse, idAnnee);
    }

    List<Eleve> findListeELeveWithGenderEqualsToF(int idClasse, int idAnnee) {
        return classeEleveRepository.findListeELeveWithGenderEqualsToF(idClasse, idAnnee);
    }

    void deleteEleveFromClasse(ClasseEleve classeEleve) {
        classeEleveRepository.delete(classeEleve);
    }


}
