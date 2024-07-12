package tn.esprint.EdTech.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprint.EdTech.Entities.*;
import tn.esprint.EdTech.Entities.Keys.AbsenceKey;
import tn.esprint.EdTech.Repositories.AbsenceRepo;
import tn.esprint.EdTech.Repositories.ClasseRepo;
import tn.esprint.EdTech.Repositories.MatiereRepo;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService{

    UtilisateurRepo utilisateurRepo;
    ClasseRepo classeRepo;
    MatiereRepo matiereRepo;
    AbsenceRepo absenceRepo;

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
    public List<Utilisateur> getUsersExceptVisitors() {
        return List.of();
    }

    @Override
    public List<Utilisateur> getAllStudents(String className) {
        Classe classe = classeRepo.findClasseByNom(className);
        return utilisateurRepo.findAllByRolesAndClasse(Role.ETUDIANT, classe);
    }

}
