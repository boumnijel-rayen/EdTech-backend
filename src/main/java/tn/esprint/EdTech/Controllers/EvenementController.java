package tn.esprint.EdTech.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Evenement;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.EvenementRepo;
import tn.esprint.EdTech.Services.EvenementServiceImpl;
import tn.esprint.EdTech.Services.IEvenementService;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class EvenementController {

    IEvenementService evenementService;

    @PostMapping("/save")
    public Evenement SaveEvent(@RequestBody Evenement evenement) {
        return evenementService.addEvent(evenement);
    }

    @PutMapping("/update")
    public Evenement UpdateEvent(@RequestBody Evenement evenement) {
        return evenementService.updateEvent(evenement);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteEvent(@PathVariable long id) {
        evenementService.deleteEvent(id);
    }

    @GetMapping("/get/{id}")
    public Evenement GetEvent(@PathVariable long id) {
        return evenementService.getEvent(id);
    }

    @GetMapping("/getall")
    public Collection<Evenement> GetAllEvents() {
        return evenementService.getAllEvents();
    }

    //CHANGE IT WITH LONGS BETTER
    @PostMapping("/addOrgTeam")
    public int insererEquipeOrganisation(@RequestBody Evenement event,@RequestBody List<Utilisateur> users){
        return evenementService.ajouterEquipeEvenement(event,users);
    }
}
