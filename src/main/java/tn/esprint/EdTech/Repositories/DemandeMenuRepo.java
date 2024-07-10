package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprint.EdTech.Entities.DemandeMenu;
import tn.esprint.EdTech.Entities.Keys.DemandeMenuKey;

public interface DemandeMenuRepo extends JpaRepository<DemandeMenu, Long> {
}
