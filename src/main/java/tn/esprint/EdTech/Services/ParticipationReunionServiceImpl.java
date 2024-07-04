package tn.esprint.EdTech.Services;

import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Keys.ParticipationReunionKey;
import tn.esprint.EdTech.Entities.ParticipationReunion;
import tn.esprint.EdTech.Repositories.ParticipationReunionRepo;

import java.util.List;

@Service
public class ParticipationReunionServiceImpl implements IParticipationReunionService{

    ParticipationReunionRepo participationReunionRepo;

    @Override
    public ParticipationReunion addParticipation(ParticipationReunion participationReunion) {
        return participationReunionRepo.save(participationReunion);
    }

    @Override
    public void deleteParticipation(ParticipationReunionKey id) {
        participationReunionRepo.deleteById(id);
    }

    @Override
    public ParticipationReunion updateParticipation(ParticipationReunion participationReunion) {
        return participationReunionRepo.save(participationReunion);
    }

    @Override
    public ParticipationReunion getParticipation(ParticipationReunionKey id) {
        return participationReunionRepo.findById(id).get();
    }

    @Override
    public List<ParticipationReunion> getAllParticipation() {
        return participationReunionRepo.findAll();
    }
}
