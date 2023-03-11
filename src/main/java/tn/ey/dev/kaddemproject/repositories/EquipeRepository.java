package tn.ey.dev.kaddemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ey.dev.kaddemproject.entities.Equipe;
import tn.ey.dev.kaddemproject.entities.Option;
import tn.ey.dev.kaddemproject.entities.Specialite;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
    List<Equipe> findByEtudiantsOptionAndEtudiantsContratsSpecialite(Option op, Specialite sp);
}
