package tn.ey.dev.kaddemproject.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idEtudiant;
    private String prenomE;
    private String nomE;

    @ManyToOne
    //@JoinColumn(name = "dept_id")
    private Departement departement;

    @Enumerated(EnumType.STRING)
    private Option option;

    @OneToMany(
            mappedBy = "etudiant")
    private List<Contrat> contrats;

    @ManyToMany(mappedBy = "etudiants")
    private List<Equipe> equipes;

}
