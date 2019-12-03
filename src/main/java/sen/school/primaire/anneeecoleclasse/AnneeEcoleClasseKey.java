package sen.school.primaire.anneeecoleclasse;

import lombok.*;
import sen.school.primaire.annee.Annee;
import sen.school.primaire.classe.Classe;
import sen.school.primaire.ecole.Ecole;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class AnneeEcoleClasseKey implements Serializable {


    @ManyToOne
    @JoinColumn(name = "idAnnee")
    private Annee annee;

    @ManyToOne
    @JoinColumn(name = "idEcole")
    private Ecole ecole;

    @ManyToOne
    @JoinColumn(name = "idClasse")
    private Classe classe;
}
