package sen.school.primaire.eleve;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class EleveRepositoryService {

    @Autowired
    EleveRepository eleveRepository;

    Optional<Eleve> findById(Integer id) {
        return eleveRepository.findById(id);
    }

    List<Eleve> findAll() {
        return eleveRepository.findAll();
    }

    void delete(Eleve eleve) {
        eleveRepository.delete(eleve);
    }

    Eleve save(Eleve annee) {
        return eleveRepository.save(annee);
    }

}
