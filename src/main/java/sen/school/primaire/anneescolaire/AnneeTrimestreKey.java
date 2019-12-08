package sen.school.primaire.anneescolaire;

import javax.persistence.Column;
import java.io.Serializable;

public class AnneeTrimestreKey implements Serializable {

    @Column(name = "idAnnee")
    private int idAnnee;

    @Column(name = "id")
    private int id;
}
