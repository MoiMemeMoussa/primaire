package sen.school.primaire.anneeecole;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnneeEcoleRepositoryService {

    @Autowired
    AnneeEcoleRepository anneeEcoleRepository;

    AnneeEcole save(AnneeEcole anneeEcole) {
        return anneeEcoleRepository.save(anneeEcole);
    }


}
