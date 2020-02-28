package sen.school.primaire.enseignant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sen.school.primaire.anneescolaire.ClasseAnnee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "enseignant")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Enseignant {

    @Id
    @Column(name = "matricule",length = 10)
    private String matricule;

    @Column(name = "first_ame",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    // Monsieur, Madamoiselle, Madame( M. ou MLLE ou MME)
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "phone",nullable = false)
    private int phone;

    @ManyToMany(mappedBy = "sontEnseignant")
    @JsonIgnore
    private Set<ClasseAnnee> classeAnnees = new HashSet<>();
}
