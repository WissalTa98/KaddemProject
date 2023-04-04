package tn.ey.dev.kaddemproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.ey.dev.kaddemproject.entities.Etudiant;
import tn.ey.dev.kaddemproject.services.IEtudiantServices;

import java.util.List;

@Tag(name = "Etudiant")
@RestController
@RequestMapping("etudiant")
@RequiredArgsConstructor
public class EtudiantController {
    //@Autowired
    IEtudiantServices iEtudiantServices;
    @GetMapping()
    public List<Etudiant> getAllEtudiant(){
        return iEtudiantServices.getAllEtudiant();
    }
    @GetMapping("/{id}")
    public Etudiant getByIdEtudiant(@PathVariable int id){
        return iEtudiantServices.getByIdEtudiant(id);
    }
    @DeleteMapping("/{id}")
    private void deleteEtudiant(@PathVariable int id){
        iEtudiantServices.deleteEtudiant(id);
    }
    @PostMapping()
    public void ajouterEtudiant(@RequestBody Etudiant etudiant){
        iEtudiantServices.ajouterEtudiant(etudiant);
    }
    @PutMapping()
    private Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        iEtudiantServices.updateEtudiant(etudiant);
        return etudiant;
    }
    @PutMapping("{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement (@PathVariable Integer etudiantId, @PathVariable Integer departementId) {
        iEtudiantServices.assignEtudiantToDepartement(etudiantId,departementId);
    } ;
    @PostMapping("{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable Integer idContrat, @PathVariable Integer idEquipe) {
        return iEtudiantServices.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }
    @GetMapping("/getEtudiantsByDepartement/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable Integer idDepartement) {
        return iEtudiantServices.getEtudiantsByDepartement(idDepartement);
    }
}
