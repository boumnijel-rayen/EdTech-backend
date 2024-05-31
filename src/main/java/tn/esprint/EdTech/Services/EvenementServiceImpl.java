package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Evenement;
import tn.esprint.EdTech.Repositories.EvenementRepo;

import java.util.List;

@Service
public class EvenementServiceImpl implements IEvenementService{

    @Autowired
    EvenementRepo EvenementRepo;

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
