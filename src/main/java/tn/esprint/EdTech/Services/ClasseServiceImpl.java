package tn.esprint.EdTech.Services;

import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Classe;
import tn.esprint.EdTech.Repositories.ClasseRepo;

import java.util.List;

@Service
public class ClasseServiceImpl implements IClasseService {

  private final ClasseRepo classeRepo;

  public ClasseServiceImpl(ClasseRepo classeRepo) {
    this.classeRepo = classeRepo;
  }

  @Override
  public List<Classe> getAllClasses() {
    return classeRepo.findAll();
  }

  @Override
  public Classe getClasseById(Long id) {
    return classeRepo.findById(id).orElse(null);
  }

  @Override
  public Classe createClasse(Classe classe) {
    return classeRepo.save(classe);
  }

  @Override
  public Classe updateClasse(Long id, Classe classe) {
    if (classeRepo.existsById(id)) {
      classe.setId(id);
      return classeRepo.save(classe);
    }
    return null;
  }

  @Override
  public void deleteClasse(Long id) {
    classeRepo.deleteById(id);
  }

}
