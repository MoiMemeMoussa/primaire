package sen.school.primaire.anneescolaire;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import sen.school.primaire.eleve.Eleve;
import sen.school.primaire.enseignant.Enseignant;
import sen.school.primaire.matiere.Matiere;

import javax.persistence.*;
import java.util.Set;

@Table(name = "classe_annee")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ClasseAnnee {

    @EmbeddedId
    ClasseAnneeKey classeAnneeKey;

    //Relations entre classe et eleve
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "classe_eleve",
            joinColumns = {@JoinColumn(name = "idAnnee"),@JoinColumn(name = "idClasse")},
            inverseJoinColumns = @JoinColumn(name = "idEleve", referencedColumnName = "idEleve"))
    private Set<Eleve> elevesInscrit;

    //Relation entre classe et enseignant
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "classe_enseignant",
            joinColumns = {@JoinColumn(name = "idAnnee"),@JoinColumn(name = "idClasse")},
            inverseJoinColumns = @JoinColumn(name = "matricule", referencedColumnName = "matricule"))
    private Set<Enseignant> sontEnseignant;

    //Relation entre classe et matiere
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "classe_matiere",
            joinColumns = {@JoinColumn(name = "idAnnee"),@JoinColumn(name = "idClasse")},
            inverseJoinColumns = @JoinColumn(name = "idMatiere", referencedColumnName = "idMatiere"))
    private Set<Matiere> sontAuProgramme;
}
