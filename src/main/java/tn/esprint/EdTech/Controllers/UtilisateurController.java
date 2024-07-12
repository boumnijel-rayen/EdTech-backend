package tn.esprint.EdTech.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Matiere;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;
import tn.esprint.EdTech.Services.IUtilisateurService;
import tn.esprint.EdTech.Services.MatiereService;
import tn.esprint.EdTech.Services.UtilisateurServiceImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UtilisateurController {
    IUtilisateurService utilisateurService;

    MatiereService matiereService;

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
    Utilisateur user = utilisateurService.getUser(id);
    List<Matiere> matieres = matiereService.getMatieresByUtilisateurId(id);
    user.setMatieres(new HashSet<>(matieres)); // Assuming you have a setter for matieres
    return user;
  }

    @GetMapping("/getall")
    public Collection<Utilisateur> GetAllUsers() {
        return utilisateurService.getAllUsers();
    }
}
