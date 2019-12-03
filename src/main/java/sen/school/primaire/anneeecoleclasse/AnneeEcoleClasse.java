package sen.school.primaire.anneeecoleclasse;

import lombok.*;
import sen.school.primaire.anneeecole.AnneeEcoleKey;
import sen.school.primaire.classe.Classe;
import sen.school.primaire.eleve.Eleve;
import sen.school.primaire.enseignant.Enseignant;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "annee_ecole_classe", uniqueConstraints = @UniqueConstraint(columnNames = {"idAnnee", "idEcole", "idClasse"}, name = "idAnneeEcoleClasse"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AnneeEcoleClasse {

    @EmbeddedId
    AnneeEcoleClasseKey anneeEcoleClasseKey;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "annee_ecole_classe_enseignant",
            joinColumns = { @JoinColumn(name = "annee_id",referencedColumnName = "idAnnee"),
                            @JoinColumn(name = "ecole_id", referencedColumnName = "idEcole"),
                            @JoinColumn(name = "classe_id",referencedColumnName = "idClasse") },
            inverseJoinColumns = { @JoinColumn(name = "enseignant_matricule",
                               referencedColumnName = "matricule") })
    private Set<Enseignant> anneeEcoleClasseEnseignant = new HashSet<>();



}
