package tn.ey.dev.kaddemproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.ey.dev.kaddemproject.entities.Etudiant;
import tn.ey.dev.kaddemproject.repositories.EtudiantRepository;

import java.util.List;

@Service
public class IEtudiantServiceImp implements IEtudiantServices{
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public void ajouterEtudiant(Etudiant e) {
        etudiantRepository.save(e);
    }

    @Override
    public void updateEtudiant(Etudiant e) {
        etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getByIdEtudiant(Integer id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);
    }
}
