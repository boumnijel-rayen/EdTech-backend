package tn.esprint.EdTech.Services;

import org.springframework.web.multipart.MultipartFile;
import tn.esprint.EdTech.Entities.Examen;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IExamenService {




    List<Examen> getAllExams();

    Optional<Examen> getExamById(Long id);

    List<Examen> getExamsByMatiereId(Long matiereId);

    Examen createExam(Examen examen);

    Examen updateExam(Long id, Examen examenDetails);

    void deleteExam(Long id);

    Examen uploadFile(Long examenId, MultipartFile file) throws IOException;
}
