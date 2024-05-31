package tn.esprint.EdTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprint.EdTech.Entities.Menu;
import tn.esprint.EdTech.Services.IMenuService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menus")
public class MenuController {

        @Autowired
        private IMenuService menuService;

        @GetMapping
        public List<Menu> getAllMenus() {
            return menuService.getAllMenus();
        }

        @GetMapping("/{id}")
        public Optional<Menu> getMenuById(@PathVariable Long id) {
            return menuService.getMenuById(id);
        }

        @PostMapping
        public Menu createMenu(@RequestBody Menu menu) {
            return menuService.saveMenu(menu);
        }

        @PutMapping("/{id}")
        public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menu) {
            Optional<Menu> existingMenu = menuService.getMenuById(id);
            if (existingMenu.isPresent()) {
                Menu updatedMenu = existingMenu.get();
                updatedMenu.setNom(menu.getNom());
                updatedMenu.setType(menu.getType());
                // Update other fields if necessary
                return menuService.saveMenu(updatedMenu);
            } else {
                return null; // or handle appropriately
            }
        }

        @DeleteMapping("/{id}")
        public void deleteMenu(@PathVariable Long id) {
            menuService.deleteMenu(id);
        }
    }


