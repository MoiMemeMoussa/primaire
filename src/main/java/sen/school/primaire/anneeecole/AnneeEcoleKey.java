package sen.school.primaire.anneeecole;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class AnneeEcoleKey implements Serializable {


    private Long idAnnee;

    private Long idEcole;
}
