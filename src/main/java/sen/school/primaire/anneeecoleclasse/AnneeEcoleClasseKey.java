package sen.school.primaire.anneeecoleclasse;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class AnneeEcoleClasseKey implements Serializable {


    private Long idAnnee;

    private Long idEcole;

    private Long idClasse;
}
