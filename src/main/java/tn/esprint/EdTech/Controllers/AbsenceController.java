package tn.esprint.EdTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Absence;
import tn.esprint.EdTech.Entities.Keys.AbsenceKey;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Services.AbsenceServiceImpl;
import tn.esprint.EdTech.Services.UtilisateurServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/absence")
public class AbsenceController {
    AbsenceServiceImpl absenceService;

    @PostMapping("/save")
    public Absence SaveAbsence(@RequestBody Absence absence) {
        return absenceService.addAbsence(absence);
    }

    @PutMapping("/update")
    public Absence UpdateAbsence(@RequestBody Absence absence) {
        return absenceService.updateAbsence(absence);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteAbsence(@PathVariable AbsenceKey id) {
        absenceService.deleteAbsence(id);
    }

    @GetMapping("/get/{id}")
    public Absence GetAbsence(@PathVariable AbsenceKey id) {
        return absenceService.getAbsence(id);
    }

    @GetMapping("/getall")
    public Collection<Absence> GetAllAbsence() {
        return absenceService.getAllAbsences();
    }
}
