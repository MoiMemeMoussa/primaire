package sen.school.primaire.anneescolaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sen.school.primaire.eleve.Eleve;

import java.util.List;

public interface ClasseEleveRepository extends JpaRepository<ClasseEleve, ClasseMatiereKey> {

    @Query("from Eleve E, ClasseEleve CE where CE.classeEleveKey.idAnnee = :idAnnee AND CE.classeEleveKey.idClasse=:idClasse AND CE.classeEleveKey.idEleve=E.idEleve ")
    List<Eleve> findListeELeveByIdClasseAndAnnee(int idAnnee, int idClasse);

    @Query("from Eleve E, ClasseEleve CE where E.idEleve= CE.classeEleveKey.idEleve AND E.idEleve= :idEleve AND  CE.classeEleveKey.idAnnee = :idAnnee AND CE.classeEleveKey.idClasse=:idClasse ")
    ClasseEleve findEleveByClasse(int idAnnee, int idClasse, int idEleve);

    @Query("from ClasseEleve CE where  CE.classeEleveKey.idAnnee = :idAnnee AND CE.classeEleveKey.idClasse=:idClasse AND CE.classeEleveKey.idEleve=:idEleve ")
    List<Eleve> deleteEleveFromClasse(int idClasse, int idAnnee, int idEleve);

    @Query("from Eleve E,ClasseEleve CE WHERE E.gender='M'" +
            " AND CE.classeEleveKey.idAnnee=:idAnnee" +
            " AND CE.classeEleveKey.idClasse=:idClasse" +
            " AND CE.classeEleveKey.idEleve = E.idEleve ")
    List<Eleve> findAllBoys(int idAnnee, int idClasse);

    @Query("from Eleve E,ClasseEleve CE WHERE E.gender='F'" +
            " AND CE.classeEleveKey.idAnnee=:idAnnee" +
            " AND CE.classeEleveKey.idClasse=:idClasse" +
            " AND CE.classeEleveKey.idEleve = E.idEleve ")
    List<Eleve> findAllGilrs(int idAnnee, int idClasse);
}
