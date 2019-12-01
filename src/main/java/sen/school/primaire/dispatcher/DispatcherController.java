package sen.school.primaire.dispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class DispatcherController {


    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/annee/create")
    public String creerAnneeScolaire() {
        return "addAnnee";
    }

    @GetMapping("/ecole/create")
    public String creerEcole() {
        return "addEcole";
    }

    @GetMapping("/classe/create")
    public String addClasse() {
        return "addClasse";
    }

    @GetMapping("/matiere/create")
    public String addMatiere() {
        return "addMatiere";
    }

    @GetMapping("/matiere/coefficient")
    public String addCoefficient() {
        return "addCoefficient";
    }

    @GetMapping("/eleve/create")
    public String inscrireEleve() {
        return "addEleve";
    }
}
