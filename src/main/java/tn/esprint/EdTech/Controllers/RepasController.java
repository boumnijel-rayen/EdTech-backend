package tn.esprint.EdTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Repas;
import tn.esprint.EdTech.Services.IRepasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/repas")
public class RepasController {
    @Autowired
    private IRepasService repasService;

    @GetMapping
    public List<Repas> getAllRepas() {
        return repasService.getAllRepas();
    }

    @GetMapping("/{id}")
    public Optional<Repas> getRepasById(@PathVariable Long id) {
        return repasService.getRepasById(id);
    }

    @PostMapping
    public Repas createRepas(@RequestBody Repas repas) {
        return repasService.saveRepas(repas);
    }

    @PutMapping("/{id}")
    public Repas updateRepas(@PathVariable Long id, @RequestBody Repas repas) {
        Optional<Repas> existingRepas = repasService.getRepasById(id);
        if (existingRepas.isPresent()) {
            Repas updatedRepas = existingRepas.get();
            updatedRepas.setNom(repas.getNom());
            updatedRepas.setCalories(repas.getCalories());
            updatedRepas.setPoidsCarbs(repas.getPoidsCarbs());
            updatedRepas.setPoidsProteines(repas.getPoidsProteines());
            updatedRepas.setPoidsFats(repas.getPoidsFats());
            // Update other fields if necessary
            return repasService.saveRepas(updatedRepas);
        } else {
            return null; // or handle appropriately
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRepas(@PathVariable Long id) {
        repasService.deleteRepas(id);
    }
}
