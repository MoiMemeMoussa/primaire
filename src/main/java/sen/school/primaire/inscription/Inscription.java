package sen.school.primaire.inscription;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "inscription", uniqueConstraints = @UniqueConstraint(columnNames = {"idAnnee", "idEcole", "idClasse", "idEleve"}, name = "idInscription"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Inscription {

    @EmbeddedId
    InscriptionKey anneeEcoleClasseEEleveKey;


}
