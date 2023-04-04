package tn.ey.dev.kaddemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.ey.dev.kaddemproject.entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    Etudiant findByNomEAndPrenomE(String nomE, String prenomE);
    List<Etudiant> findEtudiantByDepartement(Integer idDepart);
}
