package sen.school.primaire.trimestre;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class TrimestreRepositoryService {

    @Autowired
    TrimestreRepository trimestreRepository;

    Optional<Trimestre> findById(Integer id) {
        return trimestreRepository.findById(id);
    }

    List<Trimestre> findAll() {
        return trimestreRepository.findAll();
    }

    void delete(Trimestre trimestre) {
        trimestreRepository.delete(trimestre);
    }

    Trimestre save(Trimestre trimestre) {
        return trimestreRepository.save(trimestre);
    }
}
