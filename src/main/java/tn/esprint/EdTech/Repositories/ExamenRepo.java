package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprint.EdTech.Entities.Examen;
import tn.esprint.EdTech.Entities.Keys.ExamenKey;

import java.util.List;

public interface ExamenRepo extends JpaRepository<Examen, ExamenKey> {
    List<Examen> findByMatiereId(Long matiereId);

}
