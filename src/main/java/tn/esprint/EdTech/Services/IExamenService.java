package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Examen;

import java.util.List;
import java.util.Optional;

public interface IExamenService {
    List<Examen> getAllExams();

    Optional<Examen> getExamById(Long id);

    List<Examen> getExamsByMatiereId(Long matiereId);

    Examen createExam(Examen examen);

    Examen updateExam(Long id, Examen examenDetails);

    void deleteExam(Long id);
}
