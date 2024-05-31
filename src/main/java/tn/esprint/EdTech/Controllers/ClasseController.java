package tn.esprint.EdTech.Controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Classe;
import tn.esprint.EdTech.Services.IClasseService;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClasseController {

  private final IClasseService classeService;

  public ClasseController(IClasseService classeService) {
    this.classeService = classeService;
  }

  @GetMapping("/{id}")
  public Classe getClasseById(@PathVariable Long id) {
    return classeService.getClasseById(id);
  }

  @PostMapping
  public Classe createClasse(@RequestBody Classe classe) {
    return classeService.createClasse(classe);
  }

  @PutMapping("/{id}")
  public Classe updateClasse(@PathVariable Long id, @RequestBody Classe classe) {
    return classeService.updateClasse(id, classe);
  }

  @DeleteMapping("/{id}")
  public void deleteClasse(@PathVariable Long id) {
    classeService.deleteClasse(id);
  }
}
