package sen.school.primaire.anneescolaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EleveMatricule that = (EleveMatricule) o;
        return idAnnee == that.idAnnee &&
                idClasse == that.idClasse &&
                idEleve == that.idEleve;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnee, idClasse, idEleve);
    }
}
