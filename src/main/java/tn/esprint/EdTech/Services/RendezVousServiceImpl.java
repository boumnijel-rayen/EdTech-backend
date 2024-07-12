package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.RendezVous;
import tn.esprint.EdTech.Entities.Status;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.RendezVousRepo;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Scheduled(fixedRate = 30000)  // 60000 milliseconds = 1 minute
    public void updateRendezVousStatus() {
        LocalDateTime now = LocalDateTime.now();
        List<RendezVous> rendezVousList = rendezVousRepo.findAll();
        for (RendezVous rendezVous : rendezVousList) {
            if (rendezVous.getStatut() == Status.EN_ATTENTE && !rendezVous.getStartTime().isAfter(now)) {
                rendezVous.setStatut(Status.EN_COURS);
                rendezVousRepo.save(rendezVous);
            } else if (rendezVous.getStatut() == Status.EN_COURS && !rendezVous.getEndTime().isAfter(now)) {
                rendezVous.setStatut(Status.TERMINE);
                rendezVousRepo.save(rendezVous);
            }
        }
    }

    @Override
    public Map<Status, Long> getRendezVousCountByStatus() {
        List<RendezVous> rendezVousList = rendezVousRepo.findAll();
        return rendezVousList.stream()
                .collect(Collectors.groupingBy(RendezVous::getStatut, Collectors.counting()));
    }
    @Override
    public long getTotalRendezVousCount() {
        return rendezVousRepo.count();
    }

}
