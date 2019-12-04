package sen.school.primaire.anneescolaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "eleve_matricule")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EleveMatricule implements Serializable {

    @Id
    @Column(name = "idAnnee")
    private int idAnnee;

    @Id
    @Column(name = "idClasse")
    private int idClasse;

    @Id
    @Column(name = "idEleve")
    private int idEleve;




}
