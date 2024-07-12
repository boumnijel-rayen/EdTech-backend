package tn.esprint.EdTech.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Absence;
import tn.esprint.EdTech.Entities.Etat;
import tn.esprint.EdTech.Entities.Keys.AbsenceKey;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.ClasseRepo;
import tn.esprint.EdTech.Services.AbsenceServiceImpl;
import tn.esprint.EdTech.Services.IAbsenceService;
import tn.esprint.EdTech.Services.UtilisateurServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/absence")
@AllArgsConstructor
public class AbsenceController {

    IAbsenceService absenceService;

    @PostMapping("/save")
    public Absence SaveAbsence(@RequestBody Absence absence) {
        return absenceService.addAbsence(absence);
    }

    @DeleteMapping("/delete/{ide}/{idm}")
    public void DeleteAbsence(@PathVariable long ide, @PathVariable long idm) {
        absenceService.deleteAbsence(ide,idm);
    }

    @GetMapping("/get/{ide}/{idm}")
    public Etat GetAbsence(@PathVariable long ide, @PathVariable long idm) {
        return absenceService.getAbsence(ide, idm);
    }

    @GetMapping("/getall")
    public Collection<Absence> GetAllAbsence() {
        return absenceService.getAllAbsences();
    }

    @PostMapping("/assign/{ide}/{idm}")
    public Absence AddAbsenceToEtudiant(@RequestBody Absence absence,@PathVariable long ide, @PathVariable long idm) {
        return absenceService.assignAbsenceToEtudiant(absence,ide,idm);
    }

    @PutMapping("/update/{ide}/{idm}")
    public Absence updateAbsence(@RequestBody Absence absence,@PathVariable long ide, @PathVariable long idm) {
        return absenceService.updateAbsence(absence,ide,idm);
    }

    @GetMapping("/getDate/{ide}/{idm}")
    public String getDate(@PathVariable long ide, @PathVariable long idm) {
        LocalDate date = absenceService.getDate(ide, idm);
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
