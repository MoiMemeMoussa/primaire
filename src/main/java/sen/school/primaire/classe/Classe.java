package sen.school.primaire.classe;

import lombok.*;

import javax.persistence.*;

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

}
