package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprint.EdTech.Entities.Evenement;
import tn.esprint.EdTech.Entities.Utilisateur;

public interface EvenementRepo extends JpaRepository<Evenement, Long> {

}
