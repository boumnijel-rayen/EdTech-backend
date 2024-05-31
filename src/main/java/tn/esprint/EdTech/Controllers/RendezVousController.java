package tn.esprint.EdTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.RendezVous;
import tn.esprint.EdTech.Services.IRendezVousService;
import tn.esprint.EdTech.Services.RendezVousServiceImpl;

import java.util.Collection;
@RestController
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

    @GetMapping("/getall")
    public Collection<RendezVous> GetAllRdvs() {
        return rendezVousService.getAllRdvs();
    }
}
