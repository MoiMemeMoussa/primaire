package sen.school.primaire.matiere;

import lombok.*;

import javax.persistence.*;

@Table(name = "matiere", uniqueConstraints = @UniqueConstraint(columnNames = {"idMatiere"}, name = "idMatiere"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMatiere", nullable = false)
    private Long idMatiere;

    @Column(name = "name", nullable = false)
    private String name;

}
