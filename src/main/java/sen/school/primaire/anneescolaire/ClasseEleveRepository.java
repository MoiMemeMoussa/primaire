package sen.school.primaire.anneescolaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sen.school.primaire.eleve.Eleve;

import java.util.List;

public interface ClasseEleveRepository extends JpaRepository<ClasseEleve, ClasseMatiereKey> {

    @Query("from ClasseEleve CE where CE.classeEleveKey.idAnnee = :idAnnee AND CE.classeEleveKey.idClasse=:idClasse ")
    List<Eleve> findListeELeveByIdClasseAndAnnee(@Param("idClasse") int idClasse, @Param("idAnnee") int idAnnee);

    @Query("from Eleve E, ClasseEleve CE where E.idEleve= CE.classeEleveKey.idEleve AND E.idEleve= :idEleve AND  CE.classeEleveKey.idAnnee = :idAnnee AND CE.classeEleveKey.idClasse=:idClasse ")
    ClasseEleve findELeveByIdClasseAndAnnee(@Param("idClasse") int idClasse, @Param("idAnnee") int idAnnee, @Param("idEleve") int idEleve);


    @Query("from ClasseEleve CE where CE.classeEleveKey.idAnnee = :idAnnee AND CE.classeEleveKey.idClasse=:idClasse AND CE.status='R'")
    List<Eleve> findListeELeveRedoublantsByIdClasseAndAnnee(@Param("idClasse") int idClasse, @Param("idAnnee") int idAnnee);


    @Query("from ClasseEleve CE where CE.classeEleveKey.idAnnee = :idAnnee AND CE.classeEleveKey.idClasse=:idClasse AND CE.status='P'")
    List<Eleve> findListeELevePassantsByIdClasseAndAnnee(@Param("idClasse") int idClasse, @Param("idAnnee") int idAnnee);

    @Query("from Eleve E, ClasseEleve CE where E.gender='M' and E.idEleve = CE.classeEleveKey.idEleve AND CE.classeEleveKey.idAnnee = :idAnnee AND CE.classeEleveKey.idClasse=:idClasse ")
    List<Eleve> findListeELeveWithGenderEqualsToM(@Param("idClasse") int idClasse, @Param("idAnnee") int idAnnee);


    @Query("from Eleve E, ClasseEleve CE where E.gender='F' and E.idEleve = CE.classeEleveKey.idEleve AND CE.classeEleveKey.idAnnee = :idAnnee AND CE.classeEleveKey.idClasse=:idClasse ")
    List<Eleve> findListeELeveWithGenderEqualsToF(@Param("idClasse") int idClasse, @Param("idAnnee") int idAnnee);

    @Query("from ClasseEleve CE where  CE.classeEleveKey.idAnnee = :idAnnee AND CE.classeEleveKey.idClasse=:idClasse AND CE.classeEleveKey.idEleve=:idEleve ")
    List<Eleve> deleteEleveFromClasse(@Param("idClasse") int idClasse, @Param("idAnnee") int idAnnee, @Param("idAnnee") int idEleve);

}
