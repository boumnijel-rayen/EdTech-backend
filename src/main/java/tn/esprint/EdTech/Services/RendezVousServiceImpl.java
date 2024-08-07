package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.RendezVous;
import tn.esprint.EdTech.Entities.Status;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.RendezVousRepo;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;

import java.util.List;

@Service
public class RendezVousServiceImpl  implements IRendezVousService{
    @Autowired
    RendezVousRepo rendezVousRepo;
    @Autowired
    UtilisateurRepo utilisateurRepo;

    @Override
    public RendezVous addRdv(RendezVous rdv) {
        Utilisateur etu = utilisateurRepo.findById(rdv.getEtudiant().getId()).get();
        rdv.setEtudiant(etu);
        Utilisateur ens = utilisateurRepo.findById(rdv.getValidateur().getId()).get();
        rdv.setValidateur(ens);
        rdv.setStatut(Status.EN_ATTENTE);
        return rendezVousRepo.save(rdv);

    }

    @Override
    public void deleteRdv(long id) {
        rendezVousRepo.deleteById(id);
    }

    @Override
    public RendezVous updateRdv(RendezVous rdv) {
//        Utilisateur etu = utilisateurRepo.findById(rdv.getEtudiant().getId()).get();
//        rdv.setEtudiant(etu);
//        Utilisateur ens = utilisateurRepo.findById(rdv.getValidateur().getId()).get();
//        rdv.setValidateur(ens);
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
    @Override
    public void updateStatus(Long id, Status status) {
        RendezVous rendezVous = rendezVousRepo.findById(id).orElse(null);
        assert rendezVous != null;
        rendezVous.setStatut(status);
        rendezVousRepo.save(rendezVous);
    }

}
