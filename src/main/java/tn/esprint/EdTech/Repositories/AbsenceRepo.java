package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprint.EdTech.Entities.Absence;
import tn.esprint.EdTech.Entities.Keys.AbsenceKey;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence, AbsenceKey> {
}
