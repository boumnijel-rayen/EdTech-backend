package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Absence;
import tn.esprint.EdTech.Entities.Keys.AbsenceKey;

import java.util.List;

public interface IAbsenceService {
    public Absence addAbsence(Absence absence);
    public void deleteAbsence(AbsenceKey id);
    public Absence updateAbsence(Absence absence);
    public Absence getAbsence(AbsenceKey id);
    public List<Absence> getAllAbsences();
}
