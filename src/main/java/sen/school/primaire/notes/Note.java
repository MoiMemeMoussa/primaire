package sen.school.primaire.notes;

import lombok.*;
import sen.school.primaire.anneeecoleclassematiere.ClasseMatiereKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "notes", uniqueConstraints = @UniqueConstraint(columnNames = {"idAnnee", "idEcole", "idClasse", "idMatiere", "idEleve"}, name = "idNote"))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Note {

    @EmbeddedId
    NoteKey classeEnseignantKey;


}
