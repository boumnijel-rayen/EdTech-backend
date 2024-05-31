package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Classe;

import java.util.List;

public interface IClasseService {

  List<Classe> getAllClasses();

  Classe getClasseById(Long id);

  Classe createClasse(Classe classe);

  Classe updateClasse(Long id, Classe classe);

  void deleteClasse(Long id);

}
