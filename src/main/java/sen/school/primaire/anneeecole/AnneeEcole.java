package sen.school.primaire.anneeecole;

import lombok.*;

import javax.persistence.*;

@Table(name = "anneeecole", uniqueConstraints = @UniqueConstraint(columnNames = {"idAnnee", "idEcole"}, name = "idAnneeEcole"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AnneeEcole {

    @EmbeddedId
    AnneeEcoleKey anneeEcoleKey;


}
