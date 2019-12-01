package sen.school.primaire.matiere;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class MatiereRepositoryService {

    @Autowired
    MatiereRepository matiereRepository;

    Matiere save(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    Optional<Matiere> findById(Long idMatiere) {
        return matiereRepository.findById(idMatiere);
    }

    List<Matiere> findAll() {
        return matiereRepository.findAll();
    }

    void  delete(Matiere matiere) {
         matiereRepository.delete(matiere);
    }
}
