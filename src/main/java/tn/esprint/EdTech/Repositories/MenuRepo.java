package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprint.EdTech.Entities.Menu;

public interface MenuRepo extends JpaRepository<Menu, Long> {
}
