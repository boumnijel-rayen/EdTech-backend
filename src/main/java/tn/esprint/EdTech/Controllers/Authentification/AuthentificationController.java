package tn.esprint.EdTech.Controllers.Authentification;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Utilisateur;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthentificationController {

    AuthentificationService service;

    @PostMapping("/register")
    public void register(
            @RequestBody Utilisateur request
    ) throws MessagingException {
        service.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse authenticate(
            @RequestBody LoginRequest request
    ) throws MessagingException {
        return service.login(request);
    }

    @GetMapping("/activate/{token}/{email}")
    public AuthenticationResponse activation(@PathVariable("token") String token, @PathVariable("email") String email) throws MessagingException {
        return service.activateAccount(token, email);
    }
}
