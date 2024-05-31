package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.DemandeMenu;
import tn.esprint.EdTech.Entities.Keys.DemandeMenuKey;

import java.util.List;
import java.util.Optional;

public interface IDemandeMenuService {
    List<DemandeMenu> getAllDemandeMenus();
    Optional<DemandeMenu> getDemandeMenuById(DemandeMenuKey id);
    DemandeMenu saveDemandeMenu(DemandeMenu demandeMenu);
    void deleteDemandeMenu(DemandeMenuKey id);
}
