package sen.school.primaire.trimestre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import sen.school.primaire.annee.Annee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "trimestre")
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
    private int id;

    @Column(name = "value", nullable = false)
    private String value;


    @ManyToMany(mappedBy = "calendrier")
    @JsonIgnore
    private Set<Annee> annee = new HashSet<>();
}
