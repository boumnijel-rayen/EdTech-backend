package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Menu;
import tn.esprint.EdTech.Entities.Repas;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IMenuService {
        List<Menu> getAllMenus();
        Optional<Menu> getMenuById(Long id);
        Menu saveMenu(Menu menu);
        void deleteMenu(Long id);
        List<Repas> GetAllRepasUsed(LocalDate date);

}
