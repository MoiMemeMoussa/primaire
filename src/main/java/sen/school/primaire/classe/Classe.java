package sen.school.primaire.classe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sen.school.primaire.annee.Annee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "classe")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_classe")
    private int idClasse;

    @Column(name = "name",nullable = false, length=10)
    private String name;

    @ManyToMany(mappedBy = "existeClasse")
    @JsonIgnore
    private Set<Annee> annee = new HashSet<>();


}
