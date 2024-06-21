package tn.esprint.EdTech.Services;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprint.EdTech.Entities.Evenement;
import tn.esprint.EdTech.Entities.OrganiserParticiper;
import tn.esprint.EdTech.Entities.TypeUtilisateurEvenement;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.EvenementRepo;
import tn.esprint.EdTech.Repositories.OrganiserParticiperRepo;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class EvenementServiceImpl implements IEvenementService{
    EvenementRepo EvenementRepo;
    OrganiserParticiperRepo organiserParticiperRepo;
    public int ajouterEquipeEvenement(Evenement evenement, List<Utilisateur> users) {
        int numberOfRecords = 0;
        for (Utilisateur u : users) {
            if(organiserParticiperRepo.save(new OrganiserParticiper(u,evenement,TypeUtilisateurEvenement.ORG))!=null);
                numberOfRecords++;
        }
        return numberOfRecords;
    }
    @Override
    public Evenement addEvent(Evenement Evenement) {
        return EvenementRepo.save(Evenement);
    }

    @Override
    public void deleteEvent(long id) {
        EvenementRepo.deleteById(id);
    }

    @Override
    public Evenement updateEvent(Evenement Evenement) {
        return EvenementRepo.save(Evenement);
    }

    @Override
    public Evenement getEvent(long id) {
        return EvenementRepo.findById(id).get();
    }

    @Override
    public List<Evenement> getAllEvents() {
        return EvenementRepo.findAll();
    }
}
