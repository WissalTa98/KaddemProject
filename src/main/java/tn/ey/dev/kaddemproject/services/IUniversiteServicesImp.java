package tn.ey.dev.kaddemproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tn.ey.dev.kaddemproject.entities.Contrat;
import tn.ey.dev.kaddemproject.entities.Departement;
import tn.ey.dev.kaddemproject.entities.Universite;
import tn.ey.dev.kaddemproject.repositories.ContratRepository;
import tn.ey.dev.kaddemproject.repositories.DepartementRepository;
import tn.ey.dev.kaddemproject.repositories.UniversiteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class IUniversiteServicesImp implements IUniversiteServices{
    //@Autowired
    private UniversiteRepository universiteRepository;
    private final DepartementRepository departementRepository;
    private final ContratRepository contratRepository;
    @Override
    public void ajoutUniversite(Universite u) {
        universiteRepository.save(u);
    }

    @Override
    public void updateUniversite(Universite u) {
        universiteRepository.save(u);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getByIdUniversite(Integer id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUniversite(Integer id) {
        universiteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Assert.isNull(universite, "Entity must not be Null");
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        Assert.isNull(departement, "Entity must not be Null");
        universite.getDepartements().add(departement);
        universiteRepository.save(universite);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Assert.notNull(universite,"Not be Null");
        return universite.getDepartements();
    }

}
