package sen.school.primaire.anneescolaire;

import javax.persistence.Column;
import java.io.Serializable;

public class NoteKey implements Serializable {

    @Column(name = "idAnnee")
    private int idAnnee;

    @Column(name = "idClasse")
    private int idClasse;

    @Column(name = "idEleve")
    private int idEleve;

    @Column(name = "idMatiere")
    private int idMatiere;
}
