package tn.esprint.EdTech.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.RendezVous;
import tn.esprint.EdTech.Entities.Role;
import tn.esprint.EdTech.Entities.Status;
import tn.esprint.EdTech.Services.IRendezVousService;
import tn.esprint.EdTech.Services.RendezVousServiceImpl;

import java.util.Collection;
@RestController
@AllArgsConstructor
@RequestMapping("/rdv")
public class RendezVousController {
    @Autowired
    RendezVousServiceImpl rendezVousService;

    @PostMapping("/save")
    public RendezVous SaveRdv(@RequestBody RendezVous rdv) {

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
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping("/getall")
    public Collection<RendezVous> GetAllRdvs() {
        return rendezVousService.getAllRdvs();
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam Status status) {
        rendezVousService.updateStatus(id, status);
    }
}
