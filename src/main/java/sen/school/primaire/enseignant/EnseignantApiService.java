package sen.school.primaire.enseignant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sen.school.primaire.classe.Classe;

import java.util.List;
import java.util.Optional;

@Component
public class EnseignantApiService {

    @Autowired
    EnseignantRepositoryService enseignantRepositoryService;

    public Optional<Enseignant> findById(String matricule) {
        return enseignantRepositoryService.findById(matricule);
    }

    public List<Enseignant> findAll() {
        return enseignantRepositoryService.findAll();

    }


}
