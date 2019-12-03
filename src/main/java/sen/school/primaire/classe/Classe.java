package sen.school.primaire.classe;

import lombok.*;
import sen.school.primaire.anneeecole.AnneeEcole;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "classe", uniqueConstraints = @UniqueConstraint(columnNames = {"idClasse"}, name = "idClasse"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idClasse", nullable = false)
    private Long idClasse;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "anneeEcoleClasse")
    private Set<AnneeEcole> classeAnneeEcole = new HashSet<>();
}
