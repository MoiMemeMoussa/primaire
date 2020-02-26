package sen.school.primaire.matiere;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sen.school.primaire.anneescolaire.ClasseAnnee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "matiere")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMatiere")
    private int idMatiere;

    @Column(name = "name",nullable = false, length = 20)
    private String name;

    @ManyToMany(mappedBy = "sontAuProgramme")
    @JsonIgnore
    private Set<ClasseAnnee> classeAnnees = new HashSet<>();
}
