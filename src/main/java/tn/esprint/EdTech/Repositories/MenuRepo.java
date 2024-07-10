package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprint.EdTech.Entities.Menu;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {
}
