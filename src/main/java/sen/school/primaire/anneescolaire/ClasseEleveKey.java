package sen.school.primaire.anneescolaire;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClasseEleveKey implements Serializable {

    @Column(name = "id_annee")
    private int idAnnee;

    @Column(name = "id_classe")
    private int idClasse;

    @Column(name = "id_eleve")
    private int idEleve;

}
