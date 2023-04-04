package tn.ey.dev.kaddemproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "contrat")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idContrat;
    private LocalDate dateDebutContrat;
    private LocalDate dateFinContrat;
    private boolean archive;
    private int montantContrat;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

}
