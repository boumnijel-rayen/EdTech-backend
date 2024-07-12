package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Matiere;

import java.util.List;
import java.util.Optional;

public interface MatiereService {
    List<Matiere> getAllMatieres();
    Optional<Matiere> getMatiereById(Long id);
    Matiere createMatiere(Matiere matiere);
    Matiere updateMatiere(Matiere matiere);
    void deleteMatiere(Long id);
    List<Matiere> getAllMatieresByEnsg (long id);
}
