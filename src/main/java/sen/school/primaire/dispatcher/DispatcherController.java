package sen.school.primaire.dispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DispatcherController {

    //creer annee scolaire
    @GetMapping("/annee/create")
    public String creerAnneeScolaire(){
        return "addAnnee";
    }

    // creer une école
    @GetMapping("/ecole/create")
    public String creerEcole(){
        return "addEcole";
    }

    //ajouter une classe dans une école pour une année scolaire donnée
    @GetMapping("/classe/create")
    public String addClasse(){
        return "addClasse";
    }

    //creer une matiere
    @GetMapping("/matiere/create")
    public String addMatiere(){
        return "addMatiere";
    }

    //affecter un coefficient à une matiere
    @GetMapping("/matiere/coefficient")
    public String addCoefficient(){
        return "addCoefficient";
    }

    //inscrire un eleve
    @GetMapping("/eleve/create")
    public String inscrireEleve(){
        return "addEleve";
    }
}
