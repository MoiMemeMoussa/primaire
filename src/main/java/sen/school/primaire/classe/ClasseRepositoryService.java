package sen.school.primaire.classe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ClasseRepositoryService {

    @Autowired
    ClasseRepository classeRepository;

    Optional<Classe> findById(Long idClasse) {
        return classeRepository.findById(idClasse);
    }

    List<Classe> findAll() {
        return classeRepository.findAll();
    }

    Classe save(Classe classe) {
        return classeRepository.save(classe);
    }


}
