package sen.school.primaire.anneescolaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sen.school.primaire.eleve.Eleve;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "classe_matiere")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClasseMatiere {

    @EmbeddedId
    ClasseMatiereKey classeMatiereKey;

    @Column(name = "bareme")
    private int bareme;


    @ManyToMany(mappedBy = "evaluation")
    private Set<Eleve> eleveEvaluation = new HashSet<>();
}
