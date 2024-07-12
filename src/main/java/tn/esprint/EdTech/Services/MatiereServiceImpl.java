package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Matiere;
import tn.esprint.EdTech.Repositories.MatiereRepo;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereServiceImpl implements MatiereService {

    @Autowired
    private MatiereRepo matiereRepository;
    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @Override
    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    @Override
    public Optional<Matiere> getMatiereById(Long id) {
        return matiereRepository.findById(id);
    }

    @Override
    public Matiere createMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public Matiere updateMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public void deleteMatiere(Long id) {
        Matiere matiere = matiereRepository.findById(id).orElseThrow(() -> new RuntimeException("Matiere not found"));
        matiereRepository.delete(matiere);
    }

    @Override
    public List<Matiere> getAllMatieresByEnsg(long id) {
        return matiereRepository.findMatieresByEnseignantId(id);
    }
}
