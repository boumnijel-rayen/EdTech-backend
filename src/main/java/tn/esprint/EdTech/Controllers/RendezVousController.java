package tn.esprint.EdTech.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.esprint.EdTech.Entities.RendezVous;
import tn.esprint.EdTech.Entities.Role;
import tn.esprint.EdTech.Entities.Status;
import tn.esprint.EdTech.Services.IRendezVousService;
import tn.esprint.EdTech.Services.RendezVousServiceImpl;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/rdv")
public class RendezVousController {
    @Autowired
    RendezVousServiceImpl rendezVousService;

    @PostMapping("/save")
    public RendezVous SaveRdv(@RequestBody RendezVous rdv) {
        System.out.println("Received RendezVous: " + rdv);

//        if (rdv.getStartTime().isBefore(LocalDateTime.now())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Start time cannot be in the past");
//        }
//        if (rdv.getEndTime().isBefore(rdv.getStartTime())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "End time cannot be before start time");
//        }
        return rendezVousService.addRdv(rdv);
    }

    @PutMapping("/update")
    public RendezVous UpdateRdv(@RequestBody RendezVous rdv) {

        return rendezVousService.updateRdv(rdv);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteRdv(@PathVariable long id) {
        rendezVousService.deleteRdv(id);
    }

    @GetMapping("/get/{id}")
    public RendezVous GetRdv(@PathVariable long id) {
        return rendezVousService.getRdv(id);
    }

    @GetMapping("/getall")
    public Collection<RendezVous> GetAllRdvs() {
        return rendezVousService.getAllRdvs();
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam Status status) {
        rendezVousService.updateStatus(id, status);
    }
    @GetMapping("/rendezvous/status-count")
    public Map<Status, Long> getRendezVousCountByStatus() {
        return rendezVousService.getRendezVousCountByStatus();
    }
    @GetMapping("/rendezvous/total-count")
    public long getTotalRendezVousCount() {
        return rendezVousService.getTotalRendezVousCount();
    }
}
