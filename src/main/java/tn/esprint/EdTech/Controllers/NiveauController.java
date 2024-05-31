package tn.esprint.EdTech.Controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Niveau;
import tn.esprint.EdTech.Services.INiveauService;

import java.util.List;

@RestController
@RequestMapping("/niveaux")
public class NiveauController {

  private final INiveauService niveauService;

  public NiveauController(INiveauService niveauService) {
    this.niveauService = niveauService;
  }

  @GetMapping("/{id}")
  public Niveau getNiveauById(@PathVariable Long id) {
    return niveauService.getNiveauById(id);
  }

  @PostMapping
  public Niveau createNiveau(@RequestBody Niveau niveau) {
    return niveauService.createNiveau(niveau);
  }

  @PutMapping("/{id}")
  public Niveau updateNiveau(@PathVariable Long id, @RequestBody Niveau niveau) {
    return niveauService.updateNiveau(id, niveau);
  }

  @DeleteMapping("/{id}")
  public void deleteNiveau(@PathVariable Long id) {
    niveauService.deleteNiveau(id);
  }
}
