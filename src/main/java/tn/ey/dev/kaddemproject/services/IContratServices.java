package tn.ey.dev.kaddemproject.services;

import tn.ey.dev.kaddemproject.entities.Contrat;

import java.util.List;

public interface IContratServices {
    void ajouterContrat(Contrat c);
    void updateContrat(Contrat d);
    List<Contrat> getAllContrat();
    Contrat getByIdContrat(Integer id);
    void deleteContrat(Integer id);
}
