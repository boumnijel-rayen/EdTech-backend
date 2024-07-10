package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprint.EdTech.Entities.Repas;
@Repository
public interface RepasRepo extends JpaRepository<Repas, Long> {
}
