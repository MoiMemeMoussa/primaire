package sen.school.primaire.anneeecoleclasse;

import lombok.*;
import sen.school.primaire.anneeecole.AnneeEcoleKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "anneeecoleclasse", uniqueConstraints = @UniqueConstraint(columnNames = {"idAnnee", "idEcole", "idClasse"}, name = "idAnneeEcoleClasse"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AnneeEcoleClasse {

    @EmbeddedId
    AnneeEcoleClasseKey anneeEcoleClasseKey;


}
