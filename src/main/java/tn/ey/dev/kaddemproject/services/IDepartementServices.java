package tn.ey.dev.kaddemproject.services;

import tn.ey.dev.kaddemproject.entities.Departement;

import java.util.List;

public interface IDepartementServices {
    void ajouterDepartement(Departement d);
    void updateDepartement(Departement d);
    List<Departement> getAllDepartement();
    Departement getByIdDepartement(Integer id);
    void deleteDepartement(Integer id);
}
