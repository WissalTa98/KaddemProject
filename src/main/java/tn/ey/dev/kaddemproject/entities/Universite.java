package tn.ey.dev.kaddemproject.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table( name = "universite")
@Entity
public class Universite {

    @Id
    private int idUniv;
    private String nomUniv;

}
