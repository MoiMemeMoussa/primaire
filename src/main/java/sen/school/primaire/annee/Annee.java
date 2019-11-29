package sen.school.primaire.annee;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "annee", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}, name = "id"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Annee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "anneeecole",
            joinColumns = @JoinColumn(name = "idAnnee"),
            inverseJoinColumns = @JoinColumn(name = "idEcole")
    )
    private Set<sen.school.primaire.ecole.Ecole> anneeEcole = new HashSet<>();

}
