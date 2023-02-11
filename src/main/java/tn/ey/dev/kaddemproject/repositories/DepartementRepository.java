package tn.ey.dev.kaddemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ey.dev.kaddemproject.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
