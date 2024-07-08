package tn.esprint.EdTech.Controllers.Authentification;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Role;
import tn.esprint.EdTech.Entities.Token;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Exceptions.*;
import tn.esprint.EdTech.Repositories.TokenRepo;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;
import tn.esprint.EdTech.Security.JwtService;
import tn.esprint.EdTech.email.EmailService;
import tn.esprint.EdTech.email.EmailTemplateName;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthentificationService {

    UtilisateurRepo utilisateurRepo;
    PasswordEncoder passwordEncoder;
    JwtService jwtService;
    AuthenticationManager authenticationManager;
    EmailService emailService;
    TokenRepo tokenRepo;

    public void register(Utilisateur request) throws MessagingException {
        var userTest = utilisateurRepo.findByEmail(request.getEmail());
        if(!userTest.isEmpty())
            throw new forbiddenException("email_existe");
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ETUDIANT);
        var user = Utilisateur.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .enabled(false)
                .build();
        utilisateurRepo.save(user);
        sendValidationEmail(user);
    }


    public AuthenticationResponse login(LoginRequest request) throws MessagingException {
        var user = utilisateurRepo.findByEmail(request.getEmail())
                .orElseThrow();
        if (!user.isEnabled()){
            tokenRepo.deleteByUserId(user.getId());
            sendValidationEmail(user);
            throw new lockedException("Ce compte n'est pas activé un code d'activation a été envoyé par mail");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private String generateAndSaveActivationToken(Utilisateur user) {
        // Generate a token
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(2))
                .user(user)
                .build();
        tokenRepo.save(token);

        return generatedToken;
    }

    private void sendValidationEmail(Utilisateur user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);

        emailService.sendEmail(
                user.getEmail(),
                user.getNom() + " " + user.getPrenom(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                "http://localhost:4200/activate-account",
                newToken,
                "Account activation"
        );
    }

    public AuthenticationResponse activateAccount(String token, String email) throws MessagingException {
        Utilisateur user = utilisateurRepo.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé"));
        Token savedToken = tokenRepo.findByToken(token)
                // todo exception has to be defined
                .orElseThrow(() -> new conflictException("Token invalid"));

        if (savedToken.getUser().getId() != user.getId())
            throw new forbiddenException("Token invalid");

        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            tokenRepo.deleteByUserId(user.getId());
            sendValidationEmail(savedToken.getUser());
            throw new conflictException("Le token d'activation a expiré. Un nouveau token a été envoyé à la même adresse email");
        }

        user.setEnabled(true);
        utilisateurRepo.save(user);

        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepo.save(savedToken);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }
}
