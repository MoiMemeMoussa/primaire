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

    @Column(name = "idAnnee")
    private int idAnnee;

    @Column(name = "idClasse")
    private int idClasse;

    @Column(name = "idEleve")
    private int idEleve;

}
