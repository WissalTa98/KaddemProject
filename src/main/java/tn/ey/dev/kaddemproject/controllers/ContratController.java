package tn.ey.dev.kaddemproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.ey.dev.kaddemproject.entities.Contrat;
import tn.ey.dev.kaddemproject.services.IContratServices;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Tag(name = "Contrat")
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

    @PutMapping("/affectContratToEtudiant")
    public Contrat affectContratToEtudiant(@PathVariable Contrat ce, @RequestBody String nomE, @RequestBody String prenomE) {
        return iContratServices.affectContratToEtudiant(ce, nomE, prenomE);
    }

    @GetMapping("/montantContrat")
    public Map<String, Float> getMontantContratEntreDeuxDate(Integer idUniv, LocalDate startDate, LocalDate endDate){
        return iContratServices.getMontantContratEntreDeuxDate(idUniv,startDate,endDate);
    }
    @GetMapping("/nbrContratsValides/{end}/{start}")
    Integer nbContratsValides(@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end , @PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start) {
        return iContratServices.nbContratsValides(end,start) ;
    }

    @PostMapping("/updateStatut")
    public void retrieveAndUpdateStatusContrat() {
        iContratServices.retrieveAndUpdateStatusContrat();
    }

}
