package sen.school.primaire.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/connexion")
    public String verify(
            @RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password){
        log.info("======== Login ="+login);
        log.info("======== Passsword ="+password);
        return "admin";
    }
}
