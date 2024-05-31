package tn.esprint.EdTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Classe;
import tn.esprint.EdTech.Services.IClasseService;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    @Autowired
    private IClasseService classeService;

    @GetMapping
    public List<Classe> getAllClasses() {
        return classeService.getAllClasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classe> getClasseById(@PathVariable Long id) {
        Classe classe = classeService.getClasseById(id).orElseThrow(() -> new RuntimeException("Classe not found"));
        return ResponseEntity.ok(classe);
    }

    @PostMapping
    public Classe createClasse(@RequestBody Classe classe) {
        return classeService.createClasse(classe);
    }

    @PutMapping("update/{id}")
    public Classe updateClasse(@PathVariable("id") Long id, @RequestBody Classe classe) {
        classe.setId(id);
        return classeService.updateClasse(classe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return ResponseEntity.noContent().build();
    }
}
