package tn.ey.dev.kaddemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.ey.dev.kaddemproject.entities.Contrat;

import java.time.LocalDate;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    @Query("select count(c) from Contrat c where c.archive = false and c.etudiant.nomE = ?1 and c.etudiant.prenomE = ?2")
    Integer countContratByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nom, String Prenom);

    List findByEtudiant_Departement_Universite_IdAndEstArchiveAndDateDebutGreaterThanEqualAndDateFinLessThanEqual(Integer idUniversite, Boolean estArchive, LocalDate startDate, LocalDate endDate);

}
