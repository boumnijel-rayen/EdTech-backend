package tn.esprint.EdTech.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Absence;
import tn.esprint.EdTech.Entities.Classe;
import tn.esprint.EdTech.Entities.Etat;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.ClasseRepo;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;
import tn.esprint.EdTech.Services.IAbsenceService;
import tn.esprint.EdTech.Services.IUtilisateurService;
import tn.esprint.EdTech.Services.UtilisateurServiceImpl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UtilisateurController {
    IUtilisateurService utilisateurService;
    ClasseRepo classeRepo;

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

    @GetMapping("/getAllStudents/{className}")
    public List<Utilisateur> getAllStudents(@PathVariable String className) {
        return utilisateurService.getAllStudents(className);
    }
}
