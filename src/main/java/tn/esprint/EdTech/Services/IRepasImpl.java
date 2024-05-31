package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Repas;
import tn.esprint.EdTech.Repositories.RepasRepo;

import java.util.List;
import java.util.Optional;

@Service
public class IRepasImpl implements IRepasService{
    @Autowired
    private RepasRepo repasRepository;

    @Override
    public List<Repas> getAllRepas() {
        return repasRepository.findAll();
    }

    @Override
    public Optional<Repas> getRepasById(Long id) {
        return repasRepository.findById(id);
    }

    @Override
    public Repas saveRepas(Repas repas) {
        return repasRepository.save(repas);
    }

    @Override
    public void deleteRepas(Long id) {
        repasRepository.deleteById(id);
    }

}
