package sen.school.primaire.eleve;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sen.school.primaire.anneescolaire.ClasseAnnee;
import sen.school.primaire.anneescolaire.ClasseMatiere;
import sen.school.primaire.enums.GenreEnum;
import sen.school.primaire.matricule.Matricule;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "eleve")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Eleve {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEleve")
    private int idEleve;

    @Column(name = "firstName", nullable = false, length = 20)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 20)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, length = 8)
    private GenreEnum gender;

    @Column(name = "father", nullable = false, length = 20)
    private String father;

    @Column(name = "mother", nullable = false, length = 20)
    private String mother;

    @Column(name = "birthDate", nullable = false, length = 20)
    private Date birthDate;

    @Column(name = "place", nullable = false, length = 20)
    private String place;

    //Relation entre eleve et classe
    @ManyToMany(mappedBy = "elevesInscrit")
    @JsonIgnore
    private Set<ClasseAnnee> classeAnnees = new HashSet<>();

    //Relation entre eleve et matricule
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "eleve_matricule",
            joinColumns = @JoinColumn(name = "idEleve"),
            inverseJoinColumns = @JoinColumn(name = "idMatricule", referencedColumnName = "idMatricule"))
    private Set<Matricule> estIdentifie;

    //Relation entre eleve et classe_matiere
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "notes",
            joinColumns = {@JoinColumn(name = "idEleve")},
            inverseJoinColumns = {@JoinColumn(name = "idAnnee"),@JoinColumn(name = "idClasse"),@JoinColumn(name = "idMatiere")})
    private Set<ClasseMatiere> evaluation;

}
