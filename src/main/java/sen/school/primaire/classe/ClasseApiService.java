package sen.school.primaire.classe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClasseApiService {

    @Autowired
    ClasseRepositoryService classeRepositoryService;

    public Optional<Classe> findById(Long idClasse) {
        return classeRepositoryService.findById(idClasse);
    }

    public List<Classe> findAll() {
        return classeRepositoryService.findAll();

    }

    public Classe save(Classe classe){
        return classeRepositoryService.save(classe);
    }

}
