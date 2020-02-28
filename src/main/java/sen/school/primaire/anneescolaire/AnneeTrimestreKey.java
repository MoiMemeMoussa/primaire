package sen.school.primaire.anneescolaire;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class AnneeTrimestreKey implements Serializable {

    @Column(name = "id_annee")
    private int idAnnee;

    @Column(name = "id")
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnneeTrimestreKey that = (AnneeTrimestreKey) o;
        return idAnnee == that.idAnnee &&
                id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnee, id);
    }
}
