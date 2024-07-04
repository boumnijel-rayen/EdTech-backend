package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.RendezVous;
import tn.esprint.EdTech.Repositories.RendezVousRepo;

import java.util.List;
@Service
public class RendezVousServiceImpl  implements IRendezVousService{
    @Autowired
    RendezVousRepo rendezVousRepo;

    @Override
    public RendezVous addRdv(RendezVous rdv) {
        return rendezVousRepo.save(rdv);
    }

    @Override
    public void deleteRdv(long id) {
        rendezVousRepo.deleteById(id);
    }

    @Override
    public RendezVous updateRdv(RendezVous rdv) {
        return rendezVousRepo.save(rdv);
    }

    @Override
    public RendezVous getRdv(long id) {

        return rendezVousRepo.findById(id).get();
    }

    @Override
    public List<RendezVous> getAllRdvs() {

        return rendezVousRepo.findAll();
    }
}
