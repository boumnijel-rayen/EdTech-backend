package tn.esprint.EdTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Examen;
import tn.esprint.EdTech.Services.IExamenService;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamenController {
    @Autowired
    private IExamenService examenService;

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
}
