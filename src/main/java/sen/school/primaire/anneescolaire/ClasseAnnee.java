package sen.school.primaire.anneescolaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sen.school.primaire.classe.Classe;
import sen.school.primaire.eleve.Eleve;
import sen.school.primaire.enseignant.Enseignant;
import sen.school.primaire.matiere.Matiere;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "classe_annee")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClasseAnnee implements Serializable {

    @Id
    @Column(name = "idClasse")
    private int idclasse;

    @Id
    @Column(name = "idAnnee")
    private int idAnnee;


    //Relations entre classe et eleve
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "classe_eleve",
            joinColumns = {@JoinColumn(name = "idAnnee"),@JoinColumn(name = "idClasse")},
            inverseJoinColumns = @JoinColumn(name = "idEleve", referencedColumnName = "idEleve"))
    private Set<Eleve> elevesInscrit;


    //Relation entre classe et enseignant
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "classe_enseignant",
            joinColumns = {@JoinColumn(name = "idAnnee"),@JoinColumn(name = "idClasse")},
            inverseJoinColumns = @JoinColumn(name = "matricule", referencedColumnName = "matricule"))
    private Set<Enseignant> sontEnseignant;


    //Relation entre classe et matiere
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "classe_matiere",
            joinColumns = {@JoinColumn(name = "idAnnee"),@JoinColumn(name = "idClasse")},
            inverseJoinColumns = @JoinColumn(name = "idMatiere", referencedColumnName = "idMatiere"))
    private Set<Matiere> sontAuProgramme;
}
