package tn.ey.dev.kaddemproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.ey.dev.kaddemproject.entities.Equipe;
import tn.ey.dev.kaddemproject.repositories.EquipeRepository;

import java.util.List;

@Service
public class IEqupeServiceImp implements IEquipeServices{

    @Autowired
    private EquipeRepository equipeRepository;
    @Override
    public void ajouterEquipe(Equipe e) {
        equipeRepository.save(e);
    }

    @Override
    public void updateEquipe(Equipe e) {
        equipeRepository.save(e);
    }

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getByIdEquipe(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEquipe(Integer id) {
        equipeRepository.deleteById(id);
    }
}
