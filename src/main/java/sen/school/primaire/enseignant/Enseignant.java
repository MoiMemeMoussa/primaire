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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricule")
    private int matricule;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "gender",nullable = false)
    private char gender;

    @Column(name = "phone",nullable = false)
    private char phone;

    @ManyToMany(mappedBy = "sontEnseignant")
    @JsonIgnore
    private Set<ClasseAnnee> classeAnnees = new HashSet<>();
}
