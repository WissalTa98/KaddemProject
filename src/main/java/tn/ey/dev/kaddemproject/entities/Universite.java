package tn.ey.dev.kaddemproject.entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table( name = "universite")
@Entity
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUniv;
    private String nomUniv;

    @OneToMany( cascade = CascadeType.ALL,
                orphanRemoval = true
    )
    @JoinColumn(name = "university_id")
    private List<Departement> departements = new ArrayList<>();

}
