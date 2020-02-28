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

    @Column(name = "id_annee")
    private int idAnnee;

    @Column(name = "id_classe")
    private int idClasse;

    @Column(name = "id_matiere")
    private int idMatiere;
}
