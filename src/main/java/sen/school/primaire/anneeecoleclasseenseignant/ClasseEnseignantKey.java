package sen.school.primaire.anneeecoleclasseenseignant;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ClasseEnseignantKey implements Serializable {


    private Long idAnnee;

    private Long idEcole;

    private Long idClasse;

    private String matricule;
}
