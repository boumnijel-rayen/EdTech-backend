package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprint.EdTech.Entities.Menu;
import tn.esprint.EdTech.Entities.Utilisateur;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {
    @Query(value = "SELECT * FROM menu WHERE date = :date", nativeQuery = true)
    List<Menu> findAllByDate(@Param("date") LocalDate date);

}
