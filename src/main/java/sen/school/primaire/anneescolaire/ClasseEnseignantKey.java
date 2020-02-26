package sen.school.primaire.anneescolaire;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ClasseEnseignantKey implements Serializable {

    @Column(name = "idAnnee", length = 3)
    private int idAnnee;

    @Column(name = "idClasse", length = 3)
    private int idClasse;

    @Column(name = "matricule", length = 10)
    private String matricule;
}
