package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprint.EdTech.Entities.Keys.ParticipationReunionKey;
import tn.esprint.EdTech.Entities.ParticipationReunion;

@Repository
public interface ParticipationReunionRepo extends JpaRepository<ParticipationReunion, ParticipationReunionKey> {
}
