package tn.ey.dev.kaddemproject.entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table( name = "departement")
@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepart;
    private String nomDepart;

    @OneToMany(
            mappedBy = "departement",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Etudiant> etudiant = new ArrayList<>();

}
