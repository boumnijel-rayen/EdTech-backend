package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Menu;

import java.util.List;
import java.util.Optional;

public interface IMenuService {
        List<Menu> getAllMenus();
        Optional<Menu> getMenuById(Long id);
        Menu saveMenu(Menu menu);
        void deleteMenu(Long id);

}
