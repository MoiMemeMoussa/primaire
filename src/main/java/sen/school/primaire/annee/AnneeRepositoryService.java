package sen.school.primaire.annee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class AnneeRepositoryService {

    @Autowired
    AnneeRepository anneeRepository;

    Optional<Annee> findById(Long id) {
        return anneeRepository.findById(id);
    }

    List<Annee> findAll() {
        return anneeRepository.findAll();
    }

    Annee save(Annee annee) {
        return anneeRepository.save(annee);
    }

    void delete(Annee annee){
         anneeRepository.delete(annee);
    }
}
