package tn.esprint.EdTech.Controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Keys.ParticipationReunionKey;
import tn.esprint.EdTech.Entities.ParticipationReunion;
import tn.esprint.EdTech.Services.ParticipationReunionServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/participation")
public class ParticipationReunionController {
    ParticipationReunionServiceImpl participationReunionService;

    @PostMapping("/save")
    public ParticipationReunion SaveParticipation(@RequestBody ParticipationReunion participationReunion) {
        return participationReunionService.addParticipation(participationReunion);
    }

    @PutMapping("/update")
    public ParticipationReunion UpdateParticipation(@RequestBody ParticipationReunion participationReunion) {
        return participationReunionService.updateParticipation(participationReunion);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteParticipation(@PathVariable ParticipationReunionKey id) {
        participationReunionService.deleteParticipation(id);
    }

    @GetMapping("/get/{id}")
    public ParticipationReunion GetParticipation(@PathVariable ParticipationReunionKey id) {
        return participationReunionService.getParticipation(id);
    }

    @GetMapping("/getall")
    public Collection<ParticipationReunion> GetAllMatiere() {
        return participationReunionService.getAllParticipation();
    }
}
