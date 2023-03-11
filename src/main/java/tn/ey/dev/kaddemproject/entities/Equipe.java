package tn.ey.dev.kaddemproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "equipe")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idEquipe;
    private String nomEquipe;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @OneToOne(
            mappedBy = "equipe",
            cascade = CascadeType.ALL)
    private DetailEquipe detailEquipe;

    @ManyToMany
    @JsonIgnore
  /*  @JoinTable(name = "equipe_etudiant",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )*/
    private List<Etudiant> etudiants;


}
