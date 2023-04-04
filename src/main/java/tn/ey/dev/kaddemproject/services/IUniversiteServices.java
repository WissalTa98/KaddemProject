package tn.ey.dev.kaddemproject.services;

import tn.ey.dev.kaddemproject.entities.Departement;
import tn.ey.dev.kaddemproject.entities.Universite;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IUniversiteServices {
    void ajoutUniversite(Universite u);
    void updateUniversite(Universite u);
    List<Universite> getAllUniversite();
    Universite getByIdUniversite(Integer id);
    void deleteUniversite(Integer id);
    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);

}
