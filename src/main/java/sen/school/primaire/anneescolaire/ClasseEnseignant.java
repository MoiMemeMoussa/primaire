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
import java.sql.Date;

@Table(name = "classe_enseignant")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClasseEnseignant implements Serializable {

    @Id
    @Column(name = "idAnnee")
    private String idAnnee;

    @Id
    @Column(name = "idClasse")
    private int idclasse;

    @Id
    @Column(name = "matricule")
    private String matricule;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;
}
