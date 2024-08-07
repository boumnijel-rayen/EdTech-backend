package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Classe;

import java.util.List;
import java.util.Optional;

public interface IClasseService {

  List<Classe> getAllClasses();
  Optional<Classe> getClasseById(Long id);
  Classe createClasse(Classe classe);
  Classe updateClasse(Classe classe);
  void deleteClasse(Long id);
  Classe addEtudiantToClasse(Long classeId, String email);
  Classe removeEtudiantFromClasse(Long classeId, String email);

}
