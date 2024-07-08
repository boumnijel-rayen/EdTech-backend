package tn.esprint.EdTech.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Role;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;

import java.util.ArrayList;
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

    @Override
    public List<Utilisateur> getAllStudents() {
        List<Utilisateur> users= utilisateurRepo.findAll();
        List<Utilisateur> students = new ArrayList<>();
        for(Utilisateur user : users)
        {
            if(user.getRoles().contains(Role.ETUDIANT))
                students.add(user);
        }
        return students;
    }
    @Override
    public List<Utilisateur> getAllEnseignants() {
        List<Utilisateur> users= utilisateurRepo.findAll();
        List<Utilisateur> enseignants = new ArrayList<>();
        for(Utilisateur user : users)
        {
            if(user.getRoles().contains(Role.ENSEIGNANT))
                enseignants.add(user);
        }
        return enseignants;
    }

}
