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
public class ClasseMatiereKey implements Serializable {

    @Column(name = "idAnnee")
    private int idAnnee;

    @Column(name = "idClasse")
    private int idClasse;

    @Column(name = "idMatiere")
    private int idMatiere;
}
