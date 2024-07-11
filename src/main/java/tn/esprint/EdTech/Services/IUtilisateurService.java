package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Models.Chart;
import tn.esprint.EdTech.Models.ValidationsStats;
import tn.esprint.EdTech.Models.userStatus;

import java.util.List;

public interface IUtilisateurService {
    public Utilisateur addUser(Utilisateur utilisateur);
    public void deleteUser(long id);
    public Utilisateur updateUser(Utilisateur utilisateur);
    public Utilisateur getUser(long id);
    public Utilisateur getUserByEmail(String email);
    public List<Utilisateur> getAllUsers();
    public List<Utilisateur> getAllUsersExcepAdmins();
    List<Utilisateur> getAllStudents();
    List<Utilisateur> getAllEnseignants();
    public List<Utilisateur> getUsersExceptVisitors();
    public Utilisateur Archiver(long id);
    public Utilisateur Activer(long id);
    public userStatus getUserStatus();
    public Chart GetValisationStats();
}
