package sen.school.primaire.anneescolaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "notes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notes {

    @EmbeddedId
    NoteKey noteKey;

    @Column(name = "value")
    private int value;
}
