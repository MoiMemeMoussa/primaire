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
public class ClasseAnneeKey implements Serializable {

    @Column(name = "idClasse")
    private int idClasse;

    @Column(name = "idAnnee")
    private int idAnnee;
}
