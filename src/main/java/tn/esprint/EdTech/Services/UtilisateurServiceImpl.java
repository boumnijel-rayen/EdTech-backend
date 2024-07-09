package tn.esprint.EdTech.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Role;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Exceptions.forbiddenException;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService{

    UtilisateurRepo utilisateurRepo;

    @Override
    public Utilisateur addUser(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    public void deleteUser(long id) {
        utilisateurRepo.deleteById(id);
    }

    @Override
    public Utilisateur updateUser(Utilisateur utilisateur) {
        var userTest = utilisateurRepo.findByEmail(utilisateur.getEmail());
        if(!userTest.isEmpty())
            throw new forbiddenException("email_existe");

        Utilisateur user = utilisateurRepo.findById(utilisateur.getId()).get();
        user.setNom(utilisateur.getNom());
        user.setPrenom(utilisateur.getPrenom());
        user.setEmail(utilisateur.getEmail());

        return utilisateurRepo.save(user);
    }

    @Override
    public Utilisateur getUser(long id) {
        return utilisateurRepo.findById(id).get();
    }

    @Override
    public Utilisateur getUserByEmail(String email) {
        return utilisateurRepo.findByEmail(email).get();
    }

    @Override
    public List<Utilisateur> getAllUsers() {
        return utilisateurRepo.findAll();
    }

    @Override
    public List<Utilisateur> getAllUsersExcepAdmins() {
        return utilisateurRepo.findAll().stream()
                .filter(user -> user.isEnabled() && !user.getRoles().contains(Role.ADMIN))
                .toList();
    }

    @Override
    public List<Utilisateur> getUsersExceptVisitors() {
        return List.of();
    }

    @Override
    public Utilisateur Archiver(long id) {
        Utilisateur user = utilisateurRepo.findById(id).get();
        user.setArchived(true);
        return utilisateurRepo.save(user);
    }

    @Override
    public Utilisateur Activer(long id) {
        Utilisateur user = utilisateurRepo.findById(id).get();
        user.setArchived(false);
        return utilisateurRepo.save(user);
    }
}
