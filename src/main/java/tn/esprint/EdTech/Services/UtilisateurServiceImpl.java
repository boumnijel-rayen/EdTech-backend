package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService{

    @Autowired
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
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    public Utilisateur getUser(long id) {
        return utilisateurRepo.findById(id).get();
    }

    @Override
    public List<Utilisateur> getAllUsers() {
        return utilisateurRepo.findAll();
    }
}
