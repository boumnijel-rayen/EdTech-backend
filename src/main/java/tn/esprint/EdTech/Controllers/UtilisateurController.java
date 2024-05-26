package tn.esprint.EdTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UtilisateurController {
    @Autowired
    UtilisateurRepo utilisateurRepo;

    @PostMapping("/save")
    public void SaveUser(@RequestBody Utilisateur utilisateur) {
        utilisateurRepo.save(utilisateur);
    }

    @PutMapping("/update")
    public void UpdateUser(@RequestBody Utilisateur utilisateur) {
        utilisateurRepo.save(utilisateur);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteUser(@PathVariable long id) {
        utilisateurRepo.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public Utilisateur GetUser(@PathVariable long id) {
        return utilisateurRepo.findById(id).get();
    }

    @GetMapping("/getall")
    public Collection<Utilisateur> GetAllUsers() {
        return utilisateurRepo.findAll();
    }
}
