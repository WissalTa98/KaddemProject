package tn.ey.dev.kaddemproject.services;

import tn.ey.dev.kaddemproject.entities.Equipe;

import java.util.List;

public interface IEquipeServices {
    void ajouterEquipe(Equipe e);
    void updateEquipe(Equipe e);
    List<Equipe> getAllEquipe();
    Equipe getByIdEquipe(Integer id);
    void deleteEquipe(Integer id);
}
