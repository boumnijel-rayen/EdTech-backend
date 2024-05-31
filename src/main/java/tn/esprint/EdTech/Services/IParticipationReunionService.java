package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Keys.ParticipationReunionKey;
import tn.esprint.EdTech.Entities.Matiere;
import tn.esprint.EdTech.Entities.ParticipationReunion;

import java.util.List;

public interface IParticipationReunionService {
    public ParticipationReunion addParticipation(ParticipationReunion participationReunion);
    public void deleteParticipation(ParticipationReunionKey id);
    public ParticipationReunion updateParticipation(ParticipationReunion participationReunion);
    public ParticipationReunion getParticipation(ParticipationReunionKey id);
    public List<ParticipationReunion> getAllParticipation();
}
