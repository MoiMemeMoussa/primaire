package sen.school.primaire.matricule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sen.school.primaire.eleve.Eleve;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "matricule")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Matricule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMatricule")
    private int idMatricule;

    @Column(name = "value",nullable = false)
    private String value;

    @ManyToMany(mappedBy = "estIdentifie")
    @JsonIgnore
    private Set<Eleve> eleve = new HashSet<>();
}
