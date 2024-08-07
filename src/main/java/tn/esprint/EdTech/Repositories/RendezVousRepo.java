package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprint.EdTech.Entities.RendezVous;
import tn.esprint.EdTech.Entities.Utilisateur;

import java.util.List;

public interface RendezVousRepo extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findByValidateur(Utilisateur organiser);

}
