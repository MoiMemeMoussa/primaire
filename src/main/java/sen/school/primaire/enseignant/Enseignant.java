package sen.school.primaire.enseignant;

import lombok.*;

import javax.persistence.*;

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
    private Long matricule;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lasttName;

    @Column(name = "phone", nullable = false)
    private String phone;

}
