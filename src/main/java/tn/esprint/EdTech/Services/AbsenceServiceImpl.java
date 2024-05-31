package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Absence;
import tn.esprint.EdTech.Entities.Keys.AbsenceKey;
import tn.esprint.EdTech.Repositories.AbsenceRepo;

import java.util.List;

@Service
public class AbsenceServiceImpl implements IAbsenceService{

    AbsenceRepo absenceRepo;
    @Override
    public Absence addAbsence(Absence absence) {
        return absenceRepo.save(absence);
    }

    @Override
    public void deleteAbsence(AbsenceKey id) {
        absenceRepo.deleteById(id);
    }

    @Override
    public Absence updateAbsence(Absence absence) {
        return absenceRepo.save(absence);
    }

    @Override
    public Absence getAbsence(AbsenceKey id) {
        return absenceRepo.findById(id).get();
    }

    @Override
    public List<Absence> getAllAbsences() {
        return absenceRepo.findAll();
    }
}
