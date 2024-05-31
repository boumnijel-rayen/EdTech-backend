package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprint.EdTech.Entities.DemandeMenu;
import tn.esprint.EdTech.Entities.Keys.DemandeMenuKey;
import tn.esprint.EdTech.Repositories.DemandeMenuRepo;

import java.util.List;
import java.util.Optional;
@Service
public class IDemandeImpl  implements IDemandeMenuService{
    @Autowired
    private DemandeMenuRepo demandeMenuRepository;

    @Override
    public List<DemandeMenu> getAllDemandeMenus() {
        return demandeMenuRepository.findAll();
    }

    @Override
    public Optional<DemandeMenu> getDemandeMenuById(DemandeMenuKey id) {
        return demandeMenuRepository.findById(id);
    }

    @Override
    public DemandeMenu saveDemandeMenu(DemandeMenu demandeMenu) {
        return demandeMenuRepository.save(demandeMenu);
    }

    @Override
    public void deleteDemandeMenu(DemandeMenuKey id) {
        demandeMenuRepository.deleteById(id);
    }
}
