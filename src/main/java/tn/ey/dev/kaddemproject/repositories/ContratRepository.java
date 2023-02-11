package tn.ey.dev.kaddemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ey.dev.kaddemproject.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
}
