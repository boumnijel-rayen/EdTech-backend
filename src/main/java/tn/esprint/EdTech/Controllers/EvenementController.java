package tn.esprint.EdTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Evenement;
import tn.esprint.EdTech.Repositories.EvenementRepo;
import tn.esprint.EdTech.Services.EvenementServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/event")
public class EvenementController {
    @Autowired
    EvenementServiceImpl evenementService;

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
}
