package tn.esprint.EdTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.DemandeMenu;
import tn.esprint.EdTech.Entities.Keys.DemandeMenuKey;
import tn.esprint.EdTech.Services.IDemandeMenuService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demandeMenus")
public class DemandeMenuController {
    @Autowired
    private IDemandeMenuService demandeMenuService;

    @GetMapping
    public List<DemandeMenu> getAllDemandeMenus() {
        return demandeMenuService.getAllDemandeMenus();
    }

    @GetMapping("/{id}")
    public Optional<DemandeMenu> getDemandeMenuById(@PathVariable Long id) {
        return demandeMenuService.getDemandeMenuById(id);
    }

    @PostMapping
    public DemandeMenu createDemandeMenu(@RequestBody DemandeMenu demandeMenu) {
        return demandeMenuService.saveDemandeMenu(demandeMenu);
    }

    @PutMapping("/{id}")
    public DemandeMenu updateDemandeMenu(@PathVariable long id, @RequestBody DemandeMenu demandeMenu) {
        Optional<DemandeMenu> existingDemandeMenu = demandeMenuService.getDemandeMenuById(id);
        if (existingDemandeMenu.isPresent()) {
            DemandeMenu updatedDemandeMenu = existingDemandeMenu.get();
            updatedDemandeMenu.setUtilisateur(demandeMenu.getUtilisateur());
            updatedDemandeMenu.setMenu(demandeMenu.getMenu());
            return demandeMenuService.saveDemandeMenu(updatedDemandeMenu);
        } else {
            return null; // or handle appropriately
        }
    }

    @DeleteMapping("/{id}")
    public void deleteDemandeMenu(@PathVariable long id) {
        demandeMenuService.deleteDemandeMenu(id);
    }
}

