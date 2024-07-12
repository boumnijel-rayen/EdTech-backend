package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprint.EdTech.Entities.Classe;

import java.util.List;

public interface ClasseRepo  extends JpaRepository<Classe, Long> {
    @Query("SELECT m FROM Classe m JOIN m.etudiantsETenseignants e WHERE e.id = :id")
    List<Classe> findClassesByEnseignantId(@Param("id") long id);

    Classe findClasseByNom (String nom);
}
