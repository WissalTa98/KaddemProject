package tn.ey.dev.kaddemproject.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "departement")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idDepart;
    private String nomDepart;

    @OneToMany(
            mappedBy = "departement",
            cascade = CascadeType.ALL
    )
    private List<Etudiant> etudiants;

}
