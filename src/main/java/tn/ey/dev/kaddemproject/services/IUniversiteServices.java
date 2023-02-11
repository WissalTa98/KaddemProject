package tn.ey.dev.kaddemproject.services;

import tn.ey.dev.kaddemproject.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    void ajoutUniversite(Universite u);
    void updateUniversite(Universite u);
    List<Universite> getAllUniversite();
    Universite getByIdUniversite(Integer id);
    void deleteUniversite(Integer id);
}
