package tn.esprint.EdTech.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Role;
import tn.esprint.EdTech.Entities.Token;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Exceptions.forbiddenException;
import tn.esprint.EdTech.Models.Chart;
import tn.esprint.EdTech.Models.ValidationsStats;
import tn.esprint.EdTech.Models.userStatus;
import tn.esprint.EdTech.Repositories.TokenRepo;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService{

    UtilisateurRepo utilisateurRepo;
    TokenRepo tokenRepo;

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

    @Override
    public userStatus getUserStatus() {
        List<Utilisateur> users = utilisateurRepo.findAll();

        long nbArchive = users.stream().filter(user -> user.isArchived()).count();
        long nbDesactive = users.stream().filter(user -> !user.isEnabled()).count();
        long nbActive = users.stream().filter(user-> user.isEnabled() && !user.isArchived()).count();

        userStatus userStatus = new userStatus(nbArchive, nbDesactive, nbActive);
        return userStatus;
    }

    @Override
    public Chart GetValisationStats() {
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minusMonths(6).with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);

        List<Token> tokens = tokenRepo.findByValidatedAtBetween(startDate, endDate);
        List<ValidationsStats> res1 = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            LocalDateTime monthStart = startDate.plusMonths(i);
            LocalDateTime monthEnd = monthStart.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59).withNano(999999999);

            long count = tokens.stream()
                    .filter(token -> !token.getValidatedAt().isBefore(monthStart) && !token.getValidatedAt().isAfter(monthEnd))
                    .count();

            Month month = monthStart.getMonth();
            res1.add(new ValidationsStats(month.name(), count));
        }

        List<Token> tokens1 = tokenRepo.findByCreatedAtBetween(startDate, endDate);
        List<ValidationsStats> res2 = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            LocalDateTime monthStart = startDate.plusMonths(i);
            LocalDateTime monthEnd = monthStart.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59).withNano(999999999);

            long count = tokens1.stream()
                    .filter(token -> !token.getCreatedAt().isBefore(monthStart) && !token.getCreatedAt().isAfter(monthEnd))
                    .count();

            Month month = monthStart.getMonth();
            res2.add(new ValidationsStats(month.name(), count));
        }

        Chart chart = new Chart();
        chart.setValidationsStats(res1);
        chart.setCreationStats(res2);


        return chart;
    }
}
