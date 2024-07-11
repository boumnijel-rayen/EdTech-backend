package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprint.EdTech.Entities.Matiere;

import java.util.List;

public interface MatiereRepo extends JpaRepository<Matiere, Long> {

  @Query("SELECT m FROM Matiere m JOIN m.enseignants e WHERE e.id = :userId")
  List<Matiere> findMatieresByUtilisateurId(Long userId);
}
