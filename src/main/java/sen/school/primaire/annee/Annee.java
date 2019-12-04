package sen.school.primaire.annee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sen.school.primaire.classe.Classe;

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
    @Column(name = "idAnnee")
    private int idAnnee;

    @Column(name = "value")
    private String value;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "classe_annee",
            joinColumns = @JoinColumn(name = "idAnnee", referencedColumnName = "idAnnee"),
            inverseJoinColumns = @JoinColumn(name = "idClasse", referencedColumnName = "idClasse"))
    private Set<Classe> existeClasse;
}
