package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Utilisateur;

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
}
