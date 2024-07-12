package tn.esprint.EdTech.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprint.EdTech.Entities.Absence;
import tn.esprint.EdTech.Entities.Etat;
import tn.esprint.EdTech.Entities.Keys.AbsenceKey;
import tn.esprint.EdTech.Entities.Matiere;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.AbsenceRepo;
import tn.esprint.EdTech.Repositories.MatiereRepo;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AbsenceServiceImpl implements IAbsenceService{

    AbsenceRepo absenceRepo;
    UtilisateurRepo utilisateurRepo;
    MatiereRepo matiereRepo;

    @Override
    public Absence addAbsence(Absence absence) {
        return absenceRepo.save(absence);
    }
    @Override
    public void deleteAbsence(long matiereId, long etudiantId) {
        absenceRepo.deleteById(new AbsenceKey(etudiantId, matiereId));
    }

    @Override
    public Etat getAbsence(long matiereId, long etudiantId) {
        return absenceRepo.findById(new AbsenceKey(etudiantId, matiereId)).get().getEtat();
    }

    @Override
    public List<Absence> getAllAbsences() {
        return absenceRepo.findAll();
    }

    @Override
    public Absence assignAbsenceToEtudiant(Absence a, long matiereId, long etudiantId) {

        Absence absence = a;

        Utilisateur utilisateur = utilisateurRepo.findById(etudiantId).get();
        Matiere mat = matiereRepo.findById(matiereId).orElseThrow();
        a.setId_abs(new AbsenceKey(etudiantId, matiereId));
        a.setEtudiant(utilisateur);
        a.setMatiere(mat);
        return absenceRepo.save(a);
    }

    @Override
    public Absence updateAbsence(Absence abs, long matiereId, long etudiantId) {
        Absence existingAbs = absenceRepo.findById(new AbsenceKey(etudiantId, matiereId)).orElseThrow();
        existingAbs.setEtat(abs.getEtat());
        Absence updatedAbs = absenceRepo.save(existingAbs);
        return updatedAbs;
    }

    @Override
    public LocalDate getDate(long ide, long idm) {
        return absenceRepo.findById(new AbsenceKey(ide, idm)).get().getDate();
    }
}
