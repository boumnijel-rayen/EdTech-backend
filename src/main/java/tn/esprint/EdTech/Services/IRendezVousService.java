package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.RendezVous;

import java.util.List;

public interface IRendezVousService {
    public RendezVous addRdv(RendezVous rdv);
    public void deleteRdv(long id);
    public RendezVous updateRdv(RendezVous rdv);
    public RendezVous getRdv(long id);
    public List<RendezVous> getAllRdvs();
}
