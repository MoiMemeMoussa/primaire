package sen.school.primaire.ecole;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class EcoleRepositoryService {

    @Autowired
    EcoleRepository ecoleRepository;

    Optional<Ecole> findById(Long id) {
        return ecoleRepository.findById(id);
    }

    List<Ecole> findAll() {
        return ecoleRepository.findAll();
    }

    Ecole save(Ecole ecole) {
        return ecoleRepository.save(ecole);
    }

   void delete(Ecole ecole){
        ecoleRepository.delete(ecole);
   }
}
