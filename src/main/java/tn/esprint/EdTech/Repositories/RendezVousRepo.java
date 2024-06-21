package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprint.EdTech.Entities.RendezVous;

public interface RendezVousRepo extends JpaRepository<RendezVous, Long> {
}
