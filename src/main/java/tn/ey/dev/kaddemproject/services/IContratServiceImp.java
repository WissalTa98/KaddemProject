package tn.ey.dev.kaddemproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.ey.dev.kaddemproject.entities.Contrat;
import tn.ey.dev.kaddemproject.entities.Etudiant;
import tn.ey.dev.kaddemproject.repositories.ContratRepository;
import tn.ey.dev.kaddemproject.repositories.EtudiantRepository;

import java.util.List;

@Service
public class IContratServiceImp implements IContratServices {

    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public void ajouterContrat(Contrat c) {
        contratRepository.save(c);
    }

    @Override
    public void updateContrat(Contrat c) {
        contratRepository.save(c);
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getByIdContrat(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContrat(Integer id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
        Assert.notNull(etudiant,"Etudiant not find");

        if (etudiant == null || etudiant.getContrats().size() >= 5){

        }
        ce.setEtudiant(etudiant);
        return contratRepository.save(ce);
    }
}
