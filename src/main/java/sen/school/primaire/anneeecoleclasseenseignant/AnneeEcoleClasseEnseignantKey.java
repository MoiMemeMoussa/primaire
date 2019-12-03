package sen.school.primaire.anneeecoleclasseenseignant;

import lombok.*;
import sen.school.primaire.annee.Annee;
import sen.school.primaire.classe.Classe;
import sen.school.primaire.ecole.Ecole;
import sen.school.primaire.enseignant.Enseignant;

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
public class AnneeEcoleClasseEnseignantKey implements Serializable {


    @ManyToOne
    @JoinColumn(name = "idAnnee")
    private Annee anne;

    @ManyToOne
    @JoinColumn(name = "idEcole")
    private Ecole ecole;

    @ManyToOne
    @JoinColumn(name = "idClasse")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "matricule")
    private Enseignant enseignant;
}
