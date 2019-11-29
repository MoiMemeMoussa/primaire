package sen.school.primaire.matiere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MatiereApiService {

    @Autowired
    MatiereRepositoryService matiereRepositoryService;

    public Optional<Matiere> findById(Long idMatiere) {
        return matiereRepositoryService.findById(idMatiere);
    }

    public List<Matiere> findAll() {
        return matiereRepositoryService.findAll();

    }

    public Matiere save(Matiere matiere) {
        return matiereRepositoryService.save(matiere);
    }


}
