package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Absence;
import tn.esprint.EdTech.Entities.Etat;

import java.time.LocalDate;
import java.util.List;

public interface IAbsenceService {
    public Absence addAbsence(Absence absence);
    public void deleteAbsence(long matiereId, long etudiantId);
    public Etat getAbsence(long matiereId, long etudiantId);
    public List<Absence> getAllAbsences();
    public Absence assignAbsenceToEtudiant(Absence a, long matiereId, long etudiantId);
    public Absence updateAbsence(Absence abs, long matiereId, long etudiantId);
    public LocalDate getDate(long ide, long idm);

}
