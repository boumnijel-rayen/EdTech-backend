package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Niveau;

import java.util.List;

public interface INiveauService {

  List<Niveau> getAllNiveaux();

  Niveau getNiveauById(Long id);

  Niveau createNiveau(Niveau niveau);

  Niveau updateNiveau(Long id, Niveau niveau);

  void deleteNiveau(Long id);

  //i'll add other medthodes to manipulate more the data

}
