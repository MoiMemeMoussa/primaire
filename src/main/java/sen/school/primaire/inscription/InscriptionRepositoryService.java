package sen.school.primaire.inscription;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InscriptionRepositoryService {

    @Autowired
    InscriptionRepository inscriptionRepository;

    Inscription inscrire(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

}
