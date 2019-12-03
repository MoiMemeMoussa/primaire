package sen.school.primaire.anneeecole;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import sen.school.primaire.classe.Classe;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "annee_ecole")
@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class AnneeEcole {

    @EmbeddedId
    AnneeEcoleKey anneeEcoleKey;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "annee_ecole_classe",
            joinColumns = { @JoinColumn(name = "annee_id",referencedColumnName = "idAnnee"),@JoinColumn(name = "ecole_id",referencedColumnName = "idEcole"), },
            inverseJoinColumns = { @JoinColumn(name = "classe_id",referencedColumnName = "idClasse") })
    private Set<Classe> anneeEcoleClasse = new HashSet<>();

}
