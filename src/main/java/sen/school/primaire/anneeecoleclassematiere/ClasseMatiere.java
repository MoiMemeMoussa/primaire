package sen.school.primaire.anneeecoleclassematiere;

import lombok.*;
import sen.school.primaire.anneeecoleclasseenseignant.ClasseEnseignantKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "anneeecoleclassmatiere", uniqueConstraints = @UniqueConstraint(columnNames = {"idAnnee", "idEcole", "idClasse", "idMatiere"}, name = "idAnneeEcoleClasseMatiere"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClasseMatiere {

    @EmbeddedId
    ClasseMatiereKey classeEnseignantKey;


}
