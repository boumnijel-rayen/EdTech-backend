package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprint.EdTech.Entities.Examen;

import java.util.List;

public interface ExamenRepo extends JpaRepository<Examen, Long> {
    List<Examen> findByMatiereId(Long matiereId);

}
