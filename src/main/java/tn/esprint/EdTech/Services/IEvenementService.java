package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Evenement;
import tn.esprint.EdTech.Entities.Utilisateur;

import java.util.List;

public interface IEvenementService {
    public Evenement addEvent(Evenement Evenement);
    public void deleteEvent(long id);
    public Evenement updateEvent(Evenement Evenement);
    public Evenement getEvent(long id);
    public List<Evenement> getAllEvents();
    public int ajouterEquipeEvenement(Evenement evenement, List<Utilisateur> users);
}
