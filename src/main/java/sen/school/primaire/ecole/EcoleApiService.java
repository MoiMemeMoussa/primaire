package sen.school.primaire.ecole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sen.school.primaire.annee.Annee;

import java.util.List;
import java.util.Optional;

@Component
public class EcoleApiService {

    @Autowired
    EcoleRepositoryService ecoleRepositoryService;

    public Optional<Ecole> findById(int id) {
        return ecoleRepositoryService.findById(id);
    }

    public List<Ecole> findAll() {
        return ecoleRepositoryService.findAll();

    }


}
