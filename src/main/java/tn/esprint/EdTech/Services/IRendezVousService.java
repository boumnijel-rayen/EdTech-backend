package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.RendezVous;
import tn.esprint.EdTech.Entities.Role;
import tn.esprint.EdTech.Entities.Status;

import java.util.List;

public interface IRendezVousService {
    public RendezVous addRdv(RendezVous rdv);
    public void deleteRdv(long id);
    public RendezVous updateRdv(RendezVous rdv);
    public RendezVous getRdv(long id);
    public List<RendezVous> getAllRdvs();
    void updateStatus(Long id, Status status);
}
