package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Classe;
import tn.esprint.EdTech.Entities.Utilisateur;
import tn.esprint.EdTech.Repositories.ClasseRepo;
import tn.esprint.EdTech.Repositories.UtilisateurRepo;
import tn.esprint.EdTech.Exceptions.ResourceNotFoundException;


import java.util.List;
import java.util.Optional;

@Service
public class ClasseServiceImpl implements IClasseService {

  private final ClasseRepo classeRepository;
  private final UtilisateurRepo utilisateurRepository;

  @Autowired
  public ClasseServiceImpl(ClasseRepo classeRepository, UtilisateurRepo utilisateurRepository) {
    this.classeRepository = classeRepository;
    this.utilisateurRepository = utilisateurRepository;
  }



  @Override
  public List<Classe> getAllClasses() {
    return classeRepository.findAll();
  }

  @Override
  public Optional<Classe> getClasseById(Long id) {
    return classeRepository.findById(id);
  }

  @Override
  public Classe createClasse(Classe classe) {
    return classeRepository.save(classe);
  }

  @Override
  public Classe updateClasse(Classe classe) {
    return classeRepository.save(classe);
  }

  @Override
  public void deleteClasse(Long id) {
    Classe classe = classeRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Classe not found"));
    classeRepository.delete(classe);
  }

  @Override
  public Classe addEtudiantToClasse(Long classeId, String email) {
    Classe classe = classeRepository.findById(classeId)
      .orElseThrow(() -> new ResourceNotFoundException("Classe not found"));

    Utilisateur etudiant = utilisateurRepository.findByEmail(email)
      .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found"));

    etudiant.setClasse(classe);
    classe.getEtudiants().add(etudiant);

    utilisateurRepository.save(etudiant);
    return classeRepository.save(classe);
  }

  @Override
  public Classe removeEtudiantFromClasse(Long classeId, String email) {
    Classe classe = classeRepository.findById(classeId)
      .orElseThrow(() -> new ResourceNotFoundException("Classe not found"));

    Utilisateur etudiant = utilisateurRepository.findByEmail(email)
      .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found"));

    if (classe.getEtudiants().remove(etudiant)) {
      etudiant.setClasse(null);
      utilisateurRepository.save(etudiant);
      return classeRepository.save(classe);
    } else {
      throw new ResourceNotFoundException("Etudiant not found in the specified classe");
    }
  }
}
