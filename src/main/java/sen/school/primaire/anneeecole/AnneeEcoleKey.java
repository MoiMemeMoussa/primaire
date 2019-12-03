package sen.school.primaire.anneeecole;

import lombok.*;
import sen.school.primaire.annee.Annee;
import sen.school.primaire.ecole.Ecole;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class AnneeEcoleKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idAnnee")
    private Annee annee;

    @ManyToOne
    @JoinColumn(name = "idEcole")
    private Ecole ecole;
}
