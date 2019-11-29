package sen.school.primaire.eleve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EleveApiService {

    @Autowired
    EleveRepositoryService eleveRepositoryService;

    public Optional<Eleve> findById(int id) {
        return eleveRepositoryService.findById(id);
    }

    public List<Eleve> findAll() {
        return eleveRepositoryService.findAll();

    }


}
