package sen.school.primaire.enseignant;

import lombok.*;
import sen.school.primaire.anneeecoleclasse.AnneeEcoleClasse;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "enseignant", uniqueConstraints = @UniqueConstraint(columnNames = {"matricule"}, name = "matricule"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricule", nullable = false)
    private String matricule;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lasttName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "anneeEcoleClasseEnseignant")
    private Set<AnneeEcoleClasse> enseignantAnneeEcoleClasse = new HashSet<>();

}
