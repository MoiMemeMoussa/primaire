package sen.school.primaire.inscription;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class InscriptionKey implements Serializable {


    private Long idAnnee;

    private Long idEcole;

    private Long idClasse;

    private Long idEleve;
}
