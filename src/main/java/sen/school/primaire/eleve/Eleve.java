package sen.school.primaire.eleve;

import lombok.*;

import javax.persistence.*;

@Table(name = "eleve", uniqueConstraints = @UniqueConstraint(columnNames = {"idEleve"}, name = "idEleve"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEleve", nullable = false)
    private Long idEleve;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "laststName", nullable = false)
    private String lasttName;

    @Column(name = "birthDate", nullable = false)
    private String birthDate;

    @Column(name = "tutor", nullable = false)
    private String tutor;

    @Column(name = "contact", nullable = false)
    private String contact;

}
