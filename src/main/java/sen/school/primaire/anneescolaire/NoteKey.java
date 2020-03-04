package sen.school.primaire.anneescolaire;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class NoteKey implements Serializable {

    @Column(name = "idAnnee")
    private int idAnnee;

    @Column(name = "idClasse")
    private int idClasse;

    @Column(name = "idEleve")
    private int idEleve;

    @Column(name = "idMatiere")
    private int idMatiere;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteKey noteKey = (NoteKey) o;
        return idAnnee == noteKey.idAnnee &&
                idClasse == noteKey.idClasse &&
                idEleve == noteKey.idEleve &&
                idMatiere == noteKey.idMatiere;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnee, idClasse, idEleve, idMatiere);
    }
}
