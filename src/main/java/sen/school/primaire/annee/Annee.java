package sen.school.primaire.annee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sen.school.primaire.classe.Classe;
import sen.school.primaire.trimestre.Trimestre;

import javax.persistence.*;
import java.util.Set;

@Table(name = "annee")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Annee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_annee")
    private int idAnnee;

    @Column(name = "value", length = 9)
    private String value;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "classe_annee",
            joinColumns = @JoinColumn(name = "idAnnee", referencedColumnName = "id_annee"),
            inverseJoinColumns = @JoinColumn(name = "idClasse", referencedColumnName = "id_classe"))
    private Set<Classe> existeClasse;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "annee_trimestre",
            joinColumns = @JoinColumn(name = "idAnnee", referencedColumnName = "id_annee"),
            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private Set<Trimestre> calendrier;
}
