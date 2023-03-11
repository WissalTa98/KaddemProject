package tn.ey.dev.kaddemproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.ey.dev.kaddemproject.entities.Contrat;
import tn.ey.dev.kaddemproject.services.IContratServices;

import java.util.List;

@RestController
@RequestMapping("contrat")
@RequiredArgsConstructor
public class ContratController {
    //@Autowired
    private IContratServices iContratServices;

    @GetMapping()
    public List<Contrat> getAllContrat(){
        return iContratServices.getAllContrat();
    }
    @GetMapping("/{id}")
    public Contrat getByIdContrat(@PathVariable int id){
        return iContratServices.getByIdContrat(id);
    }
    @DeleteMapping("/{id}")
    private void deleteContrat(@PathVariable int id){
        iContratServices.deleteContrat(id);
    }
    @PostMapping()
    public void ajouterContrat(@RequestBody Contrat contrat){
        iContratServices.ajouterContrat(contrat);
    }
    @PutMapping()
    private Contrat updateContrat(@RequestBody Contrat contrat){
        iContratServices.updateContrat(contrat);
        return contrat;
    }

    @PutMapping()
    public Contrat affectContratToEtudiant(@PathVariable Contrat ce, @RequestBody String nomE, @RequestBody String prenomE) {
        return iContratServices.affectContratToEtudiant(ce, nomE, prenomE);
    }
}
