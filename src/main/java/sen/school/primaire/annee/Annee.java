package sen.school.primaire.annee;

import lombok.*;
import sen.school.primaire.anneeecole.AnneeEcole;
import sen.school.primaire.ecole.Ecole;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "annee", uniqueConstraints = @UniqueConstraint(columnNames = {"idAnnee"}, name = "idAnnee"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Annee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAnnee", nullable = false)
    private Long idAnnee;

    @Column(name = "value", nullable = false)
    private String value;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "annee_ecole",
            joinColumns = { @JoinColumn(name = "annee_id",referencedColumnName = "idAnnee") },
            inverseJoinColumns = { @JoinColumn(name = "ecole_id",referencedColumnName = "idEcole") })
    private Set<Ecole> anneeEcole = new HashSet<>();


}
