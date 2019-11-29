package sen.school.primaire.anneeecoleclasseenseignant;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "anneeecoleclasseenseignant", uniqueConstraints = @UniqueConstraint(columnNames = {"idAnnee", "idEcole", "idClasse", "matricule"}, name = "idAnneeEcoleClasseEnseignant"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClasseEnseignant {

    @EmbeddedId
    ClasseEnseignantKey classeEnseignantKey;


}
