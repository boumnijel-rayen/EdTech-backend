package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprint.EdTech.Entities.Evenement;
import tn.esprint.EdTech.Entities.Utilisateur;
@Repository
public interface EvenementRepo extends JpaRepository<Evenement, Long> {
    @Modifying
    @Query(value = "insert into Evenement(date,description,nom) values (:event.date,:event.description, :event.nom)",nativeQuery = true)
    Boolean ajouterEvenement(@Param("event") Evenement evenement);}
