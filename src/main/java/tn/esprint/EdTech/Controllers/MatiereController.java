package tn.esprint.EdTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Matiere;
import tn.esprint.EdTech.Services.MatiereService;

import java.util.List;

@RestController
@RequestMapping("/api/matieres")
public class MatiereController {

    @Autowired
    private MatiereService matiereService;

    @GetMapping
    public List<Matiere> getAllMatieres() {
        System.out.println("hayder");
        return matiereService.getAllMatieres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matiere> getMatiereById(@PathVariable Long id) {
        Matiere matiere = matiereService.getMatiereById(id).orElseThrow(() -> new RuntimeException("Matiere not found"));
        return ResponseEntity.ok(matiere);
    }

    @PostMapping
    public Matiere createMatiere(@RequestBody Matiere matiere) {
        return matiereService.createMatiere(matiere);
    }

    @PutMapping("update/{id}")
    public Matiere updateMatiere(@PathVariable("id") Long id, @RequestBody Matiere matiere) {
        matiere.setId(id);
        return matiereService.updateMatiere(matiere);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatiere(@PathVariable Long id) {
        matiereService.deleteMatiere(id);
        return ResponseEntity.noContent().build();
    }
}
