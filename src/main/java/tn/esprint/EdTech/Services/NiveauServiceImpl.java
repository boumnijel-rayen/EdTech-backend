package tn.esprint.EdTech.Services;

import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Niveau;
import tn.esprint.EdTech.Repositories.NiveauRepo;

import java.util.List;

@Service
public class NiveauServiceImpl implements INiveauService {

  private final NiveauRepo niveauRepo;

  public NiveauServiceImpl(NiveauRepo niveauRepo) {
    this.niveauRepo = niveauRepo;
  }

  @Override
  public List<Niveau> getAllNiveaux() {
    return niveauRepo.findAll();
  }

  @Override
  public Niveau getNiveauById(Long id) {
    return niveauRepo.findById(id).orElse(null);
  }

  @Override
  public Niveau createNiveau(Niveau niveau) {
    return niveauRepo.save(niveau);
  }

  @Override
  public Niveau updateNiveau(Long id, Niveau niveau) {
    if (niveauRepo.existsById(id)) {
      niveau.setId(id);
      return niveauRepo.save(niveau);
    }
    return null;
  }

  @Override
  public void deleteNiveau(Long id) {
    if (niveauRepo.existsById(id)) {
      niveauRepo.deleteById(id);
    }
  }


}
