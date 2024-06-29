package tn.esprint.EdTech.Controllers.Authentification;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Utilisateur;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthentificationController {

    private final AuthentificationService service;

//    @PostMapping("/register")
//    public AuthenticationResponse register(
//            @RequestBody Utilisateur request
//    ) {
//        return service.register(request);
//    }

    @PostMapping("/register")
    public void register(
            @RequestBody Utilisateur request
    ) throws MessagingException {
        service.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse authenticate(
            @RequestBody LoginRequest request
    ) {
        return service.login(request);
    }

    @PostMapping("/activate/{token}")
    public AuthenticationResponse activation(@PathVariable("token") String token) throws MessagingException {
        return service.activateAccount(token);
    }
}
