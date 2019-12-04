package sen.school.primaire.anneescolaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sen.school.primaire.matiere.Matiere;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "classe_eleve")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClasseEleve implements Serializable {
    @Id
    @Column(name = "idAnnee")
    private String idAnnee;

    @Id
    @Column(name = "idClasse")
    private int idclasse;

    @Id
    @Column(name = "idEleve")
    private int idEleve;

    @Column(name="status")
    private String status;



}
