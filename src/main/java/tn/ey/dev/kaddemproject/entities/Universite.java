package tn.ey.dev.kaddemproject.entities;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table( name = "universite")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idUniv;
    private String nomUniv;

    @OneToMany(cascade = CascadeType.ALL
    )
    //@JoinColumn(name = "university_id")
    private List<Departement> departements;

}
