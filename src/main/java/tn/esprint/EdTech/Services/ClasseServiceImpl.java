package tn.esprint.EdTech.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprint.EdTech.Entities.Classe;
import tn.esprint.EdTech.Repositories.ClasseRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseServiceImpl implements IClasseService {

    @Autowired
    private ClasseRepo classeRepository;

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
        Classe classe = classeRepository.findById(id).orElseThrow(() -> new RuntimeException("Classe not found"));
        classeRepository.delete(classe);
    }
}
