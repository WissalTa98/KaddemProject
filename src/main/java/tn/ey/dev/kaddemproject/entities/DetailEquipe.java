package tn.ey.dev.kaddemproject.entities;

import lombok.*;

import javax.persistence.*;

@Table(name = "detailEquipe")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailEquipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idDetailEquipe;
    private int salle;
    private String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    //@JoinColumn(name = "equipe_id", referencedColumnName = "idEquipe")
    private Equipe equipe;

}
