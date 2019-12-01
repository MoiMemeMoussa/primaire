package sen.school.primaire.annee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sen.school.primaire.matiere.Matiere;

import java.util.List;
import java.util.Optional;

@Component
public class AnneeApiService {

    @Autowired
    AnneeRepositoryService anneeRepositoryService;

    public Optional<Annee> findById(int id) {
        return anneeRepositoryService.findById(id);
    }

    public List<Annee> findAll() {
        return anneeRepositoryService.findAll();

    }

    public Annee save(Annee annee) {
        return anneeRepositoryService.save(annee);
    }

}
