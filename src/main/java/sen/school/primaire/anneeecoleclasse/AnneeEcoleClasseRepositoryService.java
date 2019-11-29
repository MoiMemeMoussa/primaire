package sen.school.primaire.anneeecoleclasse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnneeEcoleClasseRepositoryService {

    @Autowired
    AnneeEcoleClasseRepository anneeEcoleClasseRepository;

    AnneeEcoleClasse creerUneClasseDansUneEcole(AnneeEcoleClasse anneeEcoleClasse) {
        return anneeEcoleClasseRepository.save(anneeEcoleClasse);
    }


}
