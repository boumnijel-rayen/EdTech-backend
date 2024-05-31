package tn.esprint.EdTech.Services;

import tn.esprint.EdTech.Entities.Repas;

import java.util.List;
import java.util.Optional;

public interface IRepasService {
    List<Repas> getAllRepas();
    Optional<Repas> getRepasById(Long id);
    Repas saveRepas(Repas repas);
    void deleteRepas(Long id);

}
