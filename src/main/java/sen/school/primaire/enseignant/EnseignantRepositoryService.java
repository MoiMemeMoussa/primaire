package sen.school.primaire.enseignant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class EnseignantRepositoryService {

    @Autowired
    EnseignantRepository enseignantRepository;

    Optional<Enseignant> findById(String matricule) {
        return enseignantRepository.findById(matricule);
    }

    List<Enseignant> findAll() {
        return enseignantRepository.findAll();
    }

    void delete(Enseignant enseignant){
        enseignantRepository.delete(enseignant);
    }

    Enseignant save(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }
}
