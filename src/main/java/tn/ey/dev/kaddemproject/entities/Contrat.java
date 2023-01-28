package tn.ey.dev.kaddemproject.entities;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;

@Table ( name = "contrat")
@Entity
public class Contrat {

    @Id
    private int idContrat;
    private LocalDate dateDebutContrat;
    private LocalDate dateFinContrat;
    private boolean archive;
    private int montantContrat;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

}
