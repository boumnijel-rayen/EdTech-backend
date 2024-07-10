package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Menu;
import tn.esprint.EdTech.Entities.Repas;
import tn.esprint.EdTech.Repositories.MenuRepo;
import tn.esprint.EdTech.Repositories.RepasRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IMenuImpl implements IMenuService{
    @Autowired
    private MenuRepo menuRepository;
    @Autowired
    private RepasRepo repasRepository;


    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public Menu saveMenu(Menu menu) {
        Set<Repas> existingRepas = new HashSet<>();
        for (Repas repas : menu.getRepas()) {
            if (repasRepository.existsById(repas.getId())) {
                existingRepas.add(repasRepository.findById(repas.getId()).get());
            } else {
                existingRepas.add(repas);
            }
        }
        menu.setRepas(existingRepas);
        return menuRepository.save(menu);
    }


    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
