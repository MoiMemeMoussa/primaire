package sen.school.primaire.anneescolaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "notes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notes implements Serializable {

    @Id
    @Column(name = "idAnnee")
    private int idAnnee;

    @Id
    @Column(name = "idClasse")
    private int idClasse;

    @Id
    @Column(name = "idEleve")
    private int idEleve;

    @Id
    @Column(name = "idMatiere")
    private int idMatiere;

    @Column(name = "value")
    private int value;
}
