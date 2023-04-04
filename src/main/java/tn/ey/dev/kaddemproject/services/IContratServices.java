package tn.ey.dev.kaddemproject.services;

import tn.ey.dev.kaddemproject.entities.Contrat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IContratServices {
    void ajouterContrat(Contrat c);
    void updateContrat(Contrat d);
    List<Contrat> getAllContrat();
    Contrat getByIdContrat(Integer id);
    void deleteContrat(Integer id);
    Contrat affectContratToEtudiant (Contrat ce, String nomE , String prenomE);
    Map<String, Float> getMontantContratEntreDeuxDate(Integer idUniversite, LocalDate startDate, LocalDate endDate);
    Integer nbContratsValides(Date endDate, Date startDate);
    void retrieveAndUpdateStatusContrat();
}
