package tn.esprint.EdTech.Controllers.Authentification;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprint.EdTech.Entities.Utilisateur;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthentificationController {

    private final AuthentificationService service;

    @PostMapping("/register")
    public AuthenticationResponse register(
            @RequestBody Utilisateur request
    ) {
        return service.register(request);
    }
    @PostMapping("/login")
    public AuthenticationResponse authenticate(
            @RequestBody LoginRequest request
    ) {
        return service.login(request);
    }
}
