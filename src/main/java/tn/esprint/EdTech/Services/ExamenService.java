package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Examen;
import tn.esprint.EdTech.Entities.Keys.ExamenKey;
import tn.esprint.EdTech.Repositories.ExamenRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenService implements IExamenService{
    @Autowired
    private ExamenRepo examenRepository;
    @Override
    public List<Examen> getAllExams() {
        return examenRepository.findAll();
    }
    @Override
    public Optional<Examen> getExamById(ExamenKey id) {
        return examenRepository.findById(id);
    }

    @Override
    public List<Examen> getExamsByMatiereId(Long matiereId) {
        return examenRepository.findByMatiereId(matiereId);
    }

    @Override
    public Examen createExam(Examen examen) {
        return examenRepository.save(examen);
    }
    @Override
    public Examen updateExam(ExamenKey id, Examen examenDetails) {
        Examen examen = examenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Examen not found with id " + id));
        examen.setNote(examenDetails.getNote());
        examen.setEnonce(examenDetails.getEnonce());
        examen.setTravail(examenDetails.getTravail());
        examen.setEtudiant(examenDetails.getEtudiant());
        examen.setMatiere(examenDetails.getMatiere());
        return examenRepository.save(examen);
    }
@Override
    public void deleteExam(ExamenKey id) {
        Examen examen = examenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Examen not found with id " + id));
        examenRepository.delete(examen);
    }
}
