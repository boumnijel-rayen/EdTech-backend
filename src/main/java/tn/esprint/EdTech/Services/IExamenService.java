package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Examen;
import tn.esprint.EdTech.Entities.Keys.ExamenKey;

import java.util.List;
import java.util.Optional;

public interface IExamenService {
    List<Examen> getAllExams();

    Optional<Examen> getExamById(ExamenKey id);

    List<Examen> getExamsByMatiereId(Long matiereId);

    Examen createExam(Examen examen);

    Examen updateExam(ExamenKey id, Examen examenDetails);

    void deleteExam(ExamenKey id);
}
