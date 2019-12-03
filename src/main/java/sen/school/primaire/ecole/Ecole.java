package sen.school.primaire.ecole;

import lombok.*;
import sen.school.primaire.annee.Annee;
import sen.school.primaire.anneeecole.AnneeEcole;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "ecole", uniqueConstraints = @UniqueConstraint(columnNames = {"idEcole"}, name = "idEcole"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEcole", nullable = false)
    private Long idEcole;

    @Column(name = "name", nullable = false)
    private String name;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "anneeEcole")
    private Set<Annee> ecoleAnnee = new HashSet<>();

}
