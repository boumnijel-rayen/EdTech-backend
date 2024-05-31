package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Classe;

import java.util.List;
import java.util.Optional;

public interface ClasseService {
    List<Classe> getAllClasses();
    Optional<Classe> getClasseById(Long id);
    Classe createClasse(Classe classe);
    Classe updateClasse(Classe classe);
    void deleteClasse(Long id);

}
