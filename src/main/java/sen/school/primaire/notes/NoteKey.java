package sen.school.primaire.notes;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class NoteKey implements Serializable {


    private Long idAnnee;

    private Long idEcole;

    private Long idClasse;

    private Long idMatiere;

    private Long idEleve;

    private String matricule;

    private int value;
}
