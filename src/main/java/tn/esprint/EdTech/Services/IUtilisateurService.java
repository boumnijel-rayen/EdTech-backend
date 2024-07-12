package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Absence;
import tn.esprint.EdTech.Entities.Classe;
import tn.esprint.EdTech.Entities.Etat;
import tn.esprint.EdTech.Entities.Utilisateur;

import java.time.LocalDate;
import java.util.List;

public interface IUtilisateurService {
    public Utilisateur addUser(Utilisateur utilisateur);
    public void deleteUser(long id);
    public Utilisateur updateUser(Utilisateur utilisateur);
    public Utilisateur getUser(long id);
    public List<Utilisateur> getAllUsers();
    public List<Utilisateur> getUsersExceptVisitors();
    public List<Utilisateur> getAllStudents(String className);
}
