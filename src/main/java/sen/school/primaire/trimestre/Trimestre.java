package sen.school.primaire.trimestre;

import lombok.*;

import javax.persistence.*;

@Table(name = "trimestre", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}, name = "id"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Trimestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "value", nullable = false)
    private String value;



}
