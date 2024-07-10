package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.DemandeMenu;
import tn.esprint.EdTech.Repositories.DemandeMenuRepo;

import java.util.List;
import java.util.Optional;
@Service
public class IDemandeMenuImpl implements IDemandeMenuService{
    @Autowired
    private DemandeMenuRepo demandeMenuRepository;

    @Override
    public List<DemandeMenu> getAllDemandeMenus() {

        return demandeMenuRepository.findAll();
    }

    @Override
    public Optional<DemandeMenu> getDemandeMenuById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<DemandeMenu> getDemandeMenuById(Long id) {
        return demandeMenuRepository.findById(id);
    }

    @Override
    public DemandeMenu saveDemandeMenu(DemandeMenu demandeMenu) {
        return demandeMenuRepository.save(demandeMenu);
    }

    @Override
    public void deleteDemandeMenu(long id) {

    }

    @Override
    public void deleteDemandeMenu(Long id) {

        demandeMenuRepository.deleteById(id);
    }
}
