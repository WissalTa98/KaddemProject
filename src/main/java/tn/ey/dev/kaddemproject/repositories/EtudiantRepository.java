package tn.ey.dev.kaddemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ey.dev.kaddemproject.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
}
