package sen.school.primaire.anneeecoleclassematiere;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class AnneeEcoleClasseMatiereKey implements Serializable {


    private Long idAnnee;

    private Long idEcole;

    private Long idClasse;

    private Long idMatiere;

    private int bareme;
}
