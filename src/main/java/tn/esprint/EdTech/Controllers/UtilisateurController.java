package tn.esprint.EdTech.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;
import tn.esprint.EdTech.Services.IUtilisateurService;
import tn.esprint.EdTech.Services.UtilisateurServiceImpl;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UtilisateurController {
    IUtilisateurService utilisateurService;

    @PostMapping("/save")
    public Utilisateur SaveUser(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.addUser(utilisateur);
    }

    @PutMapping("/update")
    public Utilisateur UpdateUser(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.updateUser(utilisateur);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteUser(@PathVariable long id) {
        utilisateurService.deleteUser(id);
    }

    @GetMapping("/get/{id}")
    public Utilisateur GetUser(@PathVariable long id) {
        return utilisateurService.getUser(id);
    }

    @GetMapping("/getall")
    public Collection<Utilisateur> GetAllUsers() {
        return utilisateurService.getAllUsers();
    }
    @GetMapping("/GetMail/{mail}")
    public Utilisateur GetAllUsers(@PathVariable String mail) {
        return utilisateurService.FindUserByEmail(mail);
    }
}
