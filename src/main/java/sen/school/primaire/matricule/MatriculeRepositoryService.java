package sen.school.primaire.matricule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class MatriculeRepositoryService {

    @Autowired
    MatriculeRepository MatriculeRepository;

    Matricule save(Matricule Matricule) {
        return MatriculeRepository.save(Matricule);
    }

    Optional<Matricule> findById(Integer idMatricule) {
        return MatriculeRepository.findById(idMatricule);
    }

    List<Matricule> findAll() {
        return MatriculeRepository.findAll();
    }

    void delete(Matricule Matricule) {
        MatriculeRepository.delete(Matricule);
    }
}
