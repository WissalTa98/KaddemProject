package tn.ey.dev.kaddemproject.entities;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;

@Table ( name = "contrat")
@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;
    private LocalDate dateDebutContrat;
    private LocalDate dateFinContrat;
    private boolean archive;
    private int montantContrat;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

}
