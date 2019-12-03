package sen.school.primaire.anneeecoleclasseenseignant;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "annee_ecole_classe_enseignant", uniqueConstraints = @UniqueConstraint(columnNames = {"idAnnee", "idEcole", "idClasse", "matricule"}, name = "idAnneeEcoleClasseEnseignant"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AnneeEcoleClasseEnseignant {

    @EmbeddedId
    AnneeEcoleClasseEnseignantKey anneeEcoleClasseEnseignantKey;


}
