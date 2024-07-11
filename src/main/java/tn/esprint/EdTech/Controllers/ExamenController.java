package tn.esprint.EdTech.Controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprint.EdTech.Entities.Examen;
import tn.esprint.EdTech.Repositories.ExamenRepo;
import tn.esprint.EdTech.Services.IExamenService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/exams")
public class ExamenController {
    @Autowired
    private IExamenService examenService;

    @Autowired
    private ExamenRepo examenRepo;

    @GetMapping
    public List<Examen> getAllExams() {
        return examenService.getAllExams();
    }

    @GetMapping("/matiere/{matiereId}")
    public List<Examen> getExamsByMatiereId(@PathVariable Long matiereId) {
        return examenService.getExamsByMatiereId(matiereId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> getExamById(@PathVariable Long id) {
        return examenService.getExamById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Examen createExam(@RequestBody Examen examen) {
        return examenService.createExam(examen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examen> updateExam(@PathVariable Long id, @RequestBody Examen examenDetails) {
        return ResponseEntity.ok(examenService.updateExam(id, examenDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        examenService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<Examen> uploadFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            Examen examen = examenService.uploadFile(id, file);
            return ResponseEntity.ok(examen);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        } finally {
            // Suppression manuelle du fichier temporaire si nécessaire
            try {
                Files.deleteIfExists(file.getResource().getFile().toPath());
            } catch (IOException ex) {
                // Log l'erreur si nécessaire
            }
        }

    }
}
